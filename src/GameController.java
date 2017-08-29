import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.MatchResult;

/**
 * GameController osztály
 * 
 * @author sebokmarton
 */
public class GameController implements MouseListener {
	/**
	 * View
	 */
	private Rajzolo rajzolo;
	
	/**
	 * Modell
	 */
	private Jatek jatek;
	
	/**
     * Az ellenségek kezdő pozícióinak listája
     */
    List<Ut> kezdoPoziciok;
    
    /**
     * A játék végéig még ennyi ellenség fog létrejönni
     */
    int maradekEllenseg;
    
    /**
     * Hátrelévő idő a következő ellenség létrehozásáig
     */
    int idoLerakasig;
    
    /**
     * Az idő múlását tartja nyilván
     */
    int ido;
    
    /**
     * Időzítő a léptetéshez
     */
    Timer timer;
    
    /**
     * Időzítő felbontása másodpercben (konstans)
     */
    private static final int INTERVAL = 1000 * 1;
    
    /**
     * A játék állapota
     */
    Allapotok allapot;
    
    /**
     * Lehetséges állapotok
     */
    enum Allapotok {
    	FUT, NYERTUNK, VESZTETTUNK
    };
	
	/**
	 * A program belépési pontja
	 * 
	 * @param args Parancssori argumentumok
	 */
	public static void main(String[] args) {
		new GameController();
	}
	
	/**
	 * Konstruktor
	 */
	public GameController() {
		jatek = new Jatek(this);
		rajzolo = new Rajzolo(this);
		
		// ablak megjelenítése
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                rajzolo.setVisible(true);
            }
        });
	}
	
	/**
     * Játék indítása
     * A térképfájl betöltése
     * 
     * @param terkep A térképfájl elérési útvonala
     */
    public void indit(String terkep) {
    	// a játéktér cellái a modell számára
    	Cella[][] cellak;
    	List<Ellenseg> ellensegek;
    	
    	// a megjelenítendő cellák és ellenségek a view számára
    	HashMap<Cella, Kirajzolhato> rajzoloPalya = new HashMap<Cella, Kirajzolhato>();
    	HashMap<Ellenseg, EllensegRajzol> rajzoloEllensegek = new HashMap<Ellenseg, EllensegRajzol>();
    	
		try {
			Scanner f = new Scanner(new FileReader(terkep));
			
			// szélesség és magasság
			f.findInLine("(\\d+),(\\d+)");
			MatchResult m = f.match();
			int magassag = Integer.parseInt(m.group(1)), szelesseg = Integer.parseInt(m.group(2));
			f.nextLine();
			
			// cellák, első koordináta a sor, második koordináta az oszlop
			cellak = new Cella[magassag][szelesseg];
			for (int i = 0; i < magassag; i++) {
				String s = f.nextLine();
				
				for (int j = 0; j < szelesseg; j++) {
					Cella c = null;
					Kirajzolhato k = null;
					
					// cella létrehozása a betűjel alapján
					switch (s.charAt(j)) {
						case 'U':
							Ut ut = new Ut();
							c = ut;
							k = new UtRajzol(ut);
							break;
						case 'D':
							Domborzat domborzat = new Domborzat();
							c = domborzat;
							k = new DomborzatRajzol(domborzat);
							break;
						case 'V':
							VegzetHegye vegzetHegye = new VegzetHegye(jatek);
							c = vegzetHegye;
							k = new VegzetHegyeRajzol(vegzetHegye);
							break;
					}
					
					// a tömbök feltöltése
					c.setPozicio(new Pont(i + 1, j + 1));
					cellak[i][j] = c;
					rajzoloPalya.put(c, k);
				}
			}
			
			// ellenségek kezdő pozíciói
			kezdoPoziciok = new ArrayList<Ut>();
			
			int k = f.nextInt();
			f.nextLine();
			
			for (int i = 0; i < k; i++) {				
				f.findInLine("(\\d+),(\\d+)");
				MatchResult koordinata = f.match();
				int x = Integer.parseInt(koordinata.group(1)), y = Integer.parseInt(koordinata.group(2));
				f.nextLine();
				
				kezdoPoziciok.add((Ut)cellak[x - 1][y - 1]);
			}
			
			// következő lépések
			int l = f.nextInt();
			f.nextLine();
			
			for (int i = 0; i < l; i++) {
				String s = f.nextLine();
				String[] koordinatak = s.split(";");
				
				// a kezdőpont meghatározása
				Scanner sor = new Scanner(koordinatak[0]);
				sor.findInLine("(\\d+),(\\d+)");
				MatchResult koordinata = sor.match();
				int x = Integer.parseInt(koordinata.group(1)), y = Integer.parseInt(koordinata.group(2));
				sor.close();
				
				Ut ut = (Ut)cellak[x - 1][y - 1];
				List<Ut> vegpontok = new ArrayList<Ut>();
				
				// a végpontok meghatározása
				for (int j = 1; j < koordinatak.length; j++) {
					sor = new Scanner(koordinatak[j]);
					sor.findInLine("(\\d+),(\\d+)");
					koordinata = sor.match();
					x = Integer.parseInt(koordinata.group(1));
					y = Integer.parseInt(koordinata.group(2));
					sor.close();
					
					vegpontok.add((Ut)cellak[x - 1][y - 1]);
				}
				
				ut.setKovetkezoLepesek(vegpontok);
			}
			f.close();
			
			// további attribútumok inicializálása
			ellensegek = new ArrayList<Ellenseg>();
			maradekEllenseg = k * 3;
			idoLerakasig = 0;
			ido = 1;
			
			// modell beállítása
			jatek.setCellak(cellak);
			jatek.setEllensegek(ellensegek);
			jatek.setVarazsero(1000);
			jatek.setTornyok(new ArrayList<Torony>());
			
			// view beállítása
			rajzolo.setPalya(rajzoloPalya);
			rajzolo.setEllensegek(rajzoloEllensegek);
			
			// futó játék megállítása
			if (timer != null) {
				timer.cancel();
			}
			
			// most kezdünk
			allapot = Allapotok.FUT;
			
			// időzítő elindítása a léptetéshez
			timer = new Timer(true);
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					leptet(1);
				}
			}, 0, INTERVAL);
		} catch (FileNotFoundException e) {
			alert(String.format("%s betoltese nem sikerult.", terkep));
			return;
		}
    }
    
    /**
     * A játék léptetése
     * 
     * @param mennyi Ennyi egységgel léptetünk
     */
    public void leptet(int mennyi) {
    	for (int i = 0; i < mennyi; i++) {
    		// a játék szereplőit a folytonosság biztosítása céljában nagyobb felbontással léptetjük
    		// először az ellenségek lépnek
    		jatek.ellensegLep();
    		
    		// majd a tornyok tüzelnek
    		jatek.toronyTuzel();
    		
    		// ezután új ellenséget rakunk le, ha szükséges
    		for (int j = 0; j < 10; j++) {
    			// új ellenségek lerakása, ha van még ellenség és eljött az ideje
    			if (maradekEllenseg > 0) {
    				if (idoLerakasig == 0) {
    					// minden kezdő pozícióra 3 ellenség kerül, először egyedül, majd párban
    					int kezdok = kezdoPoziciok.size();
    					
    					// lerakott ellenségek számának kiszámítása
    					int lerakottEllenseg = 3 * kezdok - maradekEllenseg;
    					
    					// az ellenség kezdő pozíciójának meghatározása
    					int melyikKezdoPozicio = lerakottEllenseg < kezdok ? lerakottEllenseg : (int)((lerakottEllenseg - kezdok) / 2);
    					Ut kezdoPozicio = kezdoPoziciok.get(melyikKezdoPozicio);
	    				
	    				// a típus a kezdő pozíciókon ciklikusan váltakozik
	    				switch (melyikKezdoPozicio % 4) {
	    					case 0:
	    						Ember ember = new Ember(jatek);
	    						ember.setPozicio(kezdoPozicio);
	    						ember.initElet();
	    						addEllenseg(ember);
	    						break;
	    					case 1:
	    						Hobbit hobbit = new Hobbit(jatek);
	    						hobbit.setPozicio(kezdoPozicio);
	    						hobbit.initElet();
	    						addEllenseg(hobbit);
	    						break;
	    					case 2:
	    						Tunde tunde = new Tunde(jatek);
	    						tunde.setPozicio(kezdoPozicio);
	    						tunde.initElet();
	    						addEllenseg(tunde);
	    						break;
	    					case 3:
	    						Torp torp = new Torp(jatek);
	    						torp.setPozicio(kezdoPozicio);
	    						torp.initElet();
	    						addEllenseg(torp);
	    						break;
	    				}
	    				
	    				// számlálók frissítése
	    				maradekEllenseg--;
	    				lerakottEllenseg++;
	    				
	    				// az új ellenség lerakásáig hátralévő idő beállítása
	    				if (lerakottEllenseg <= kezdok || (lerakottEllenseg % 2) == 1)
	    					// egyesével
	    					idoLerakasig = 50 - lerakottEllenseg;
	    				else
	    					// párban
	    					idoLerakasig = 10;
    				} else
    					// csökkentjük a következő ellenség lerakásásig hátralévő időt
    					idoLerakasig--;
    			}
    			
    			// regisztráljuk az idő múlását
    			ido++;
    		}
    		
    		// végül ködöt eresztünk el a tornyokra, ha szükséges
    		if (ido % 100 == 1) {
    			jatek.kodosit();
    		}
    		
    		// frissítjük a pálya képét a view-ban
    		rajzol();
    		
    		// ha vége a játéknak
        	if (allapot == Allapotok.NYERTUNK || allapot == Allapotok.VESZTETTUNK) {
        		// időzítő leállítása
                timer.cancel();
                
                // üzenet megjelenítése
            	rajzolo.vege(allapot == Allapotok.NYERTUNK);
            	break;
        	}
    	}
    }
    
    /**
     * Játék felületének frissítése a view-ban
     */
    private void rajzol() {
    	rajzolo.rajzol(jatek.getVarazsero());
    }
    
    /**
     * Új ember hozzáadása a játékhoz
     * 
     * @param e ellenség
     */
    public void addEllenseg(Ember e) {
    	jatek.addEllenseg(e, e.getPozicio());
		rajzolo.addEllenseg(e.getPozicio(), e, new EmberRajzol(e));
    }
    
    /**
     * Új hobbit hozzáadása a játékhoz
     * 
     * @param e ellenség
     */
    public void addEllenseg(Hobbit e) {
    	jatek.addEllenseg(e, e.getPozicio());
		rajzolo.addEllenseg(e.getPozicio(), e, new HobbitRajzol(e));
    }
    
    /**
     * Új törp hozzáadása a játékhoz
     * 
     * @param e ellenség
     */
    public void addEllenseg(Torp e) {
    	jatek.addEllenseg(e, e.getPozicio());
		rajzolo.addEllenseg(e.getPozicio(), e, new TorpRajzol(e));
    }
    
    /**
     * Új tünde hozzáadása a játékhoz
     * 
     * @param e ellenség
     */
    public void addEllenseg(Tunde e) {
    	jatek.addEllenseg(e, e.getPozicio());
		rajzolo.addEllenseg(e.getPozicio(), e, new TundeRajzol(e));
    }
    
    /**
	 * Figyelmeztetés megjelenítése
	 * 
	 * @param str üzenet szövege
	 */
	public void alert(String str) {
		rajzolo.alert(str);
	}
	
	/**
	 * Ellenség halálának jelzése
	 * 
	 * @param ellenseg elhalálozott ellenség
	 * @param ellensegekSize a pályán maradt ellenségek száma
	 */
	public void meghal(Ellenseg ellenseg, int ellensegekSize) {
		// törlés a view-ból
		rajzolo.meghalEllenseg(ellenseg);
		
		// ha elfogytak az ellenségek, nyertünk
        if (ellensegekSize == 0 && maradekEllenseg == 0) 
            vege(true);
	}
	
	/**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * 
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     */
    public void vege(boolean nyertunk) {
    	allapot = nyertunk ? Allapotok.NYERTUNK : Allapotok.VESZTETTUNK;
    }
    
    /**
     * Jelzi a view-nak, ha egy ellenség helyet változtatott
     * 
     * @param ellenseg ellenség
     * @param ut új helye
     */
    public void atlep(Ellenseg ellenseg, Ut ut) {
    	rajzolo.atlep(ut, ellenseg);
    }
    
    /**
     * A térkép egér kattintás kezelése
     */
	@Override
	public void mouseClicked(MouseEvent evt) {
		// bal gombbal
		if (evt.getButton() == MouseEvent.BUTTON1) {
			int lerakando = rajzolo.getLerakandoElem();
			int x = evt.getX(), y = evt.getY();
			
			// koordináták értelmezése
			int i = y / Rajzolo.CELLAMERET + 1, j = x / Rajzolo.CELLAMERET + 1;
			Cella c = jatek.getCella(i, j);
			if (c != null) {
				switch (lerakando) {
					case 0:
						// torony (400)
						Torony torony = new Torony(jatek);
						if (jatek.lerakTorony(c, torony)) {
							rajzolo.lerakTorony(new ToronyRajzol(torony), c);
							rajzol();
						}
						break;
					case 1:
						// zöld kő (100)
						if (jatek.lerakToronyKo(c, new ZoldKo())) {
							rajzolo.lerakToronyKo(new ZoldKoRajzol(), c);
							rajzol();
						}
						break;
					case 2:
						// kék kő (100)
						if (jatek.lerakToronyKo(c, new KekKo())) {
							rajzolo.lerakToronyKo(new KekKoRajzol(), c);
							rajzol();
						}
						break;
					case 3:
						// ember piros kő (100)
						if (jatek.lerakToronyKo(c, new EmberPirosKo())) {
							rajzolo.lerakToronyKo(new EmberPirosKoRajzol(), c);
							rajzol();
						}
						break;
					case 4:
						// hobbit piros kő (100)
						if (jatek.lerakToronyKo(c, new HobbitPirosKo())) {
							rajzolo.lerakToronyKo(new HobbitPirosKoRajzol(), c);
							rajzol();
						}
						break;
					case 5:
						// törp piros kő (100)
						if (jatek.lerakToronyKo(c, new TorpPirosKo())) {
							rajzolo.lerakToronyKo(new TorpPirosKoRajzol(), c);
							rajzol();
						}
						break;
					case 6:
						// tünde piros kő (100)
						if (jatek.lerakToronyKo(c, new TundePirosKo())) {
							rajzolo.lerakToronyKo(new TundePirosKoRajzol(), c);
							rajzol();
						}
						break;
					case 7:
						// akadály (300)
						if (jatek.lerakAkadaly(c, new Akadaly())) {
							rajzolo.lerakAkadaly(new AkadalyRajzol(), c);
							rajzol();
						}
						break;
					case 8:
						// sárga kő (100)
						if (jatek.lerakAkadalyKo(c, new SargaKo())) {
							rajzolo.lerakAkadalyKo(new SargaKoRajzol(), c);
							rajzol();
						}
						break;
				}
			}
		}
	}

	/**
     * A térkép egér belépés kezelése
     */
	@Override
	public void mouseEntered(MouseEvent arg0) { }

	/**
     * A térkép egér kilépés kezelése
     */
	@Override
	public void mouseExited(MouseEvent arg0) { }

	/**
     * A térkép egér lenyomás kezelése
     */
	@Override
	public void mousePressed(MouseEvent arg0) { }

	/**
     * A térkép egér felengedés kezelése
     */
	@Override
	public void mouseReleased(MouseEvent arg0) { }
}
