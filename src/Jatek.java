import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Játék osztály
 *
 * @author sebokmarton
 */
public class Jatek {
	/**
	 * A játéktér cellái
	 */
    public Cella[][] cellak;
    
    /**
     * Ellenségek listája
     */
    List<Ellenseg> ellensegek;
    
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
     * Tornyok listája
     */
    List<Torony> tornyok;
    
    /**
     * A játékos varázsereje
     */
    int varazsero;
    
    /**
     * Az idő múlását tartja nyilván
     */
    int ido;
    
    /**
     * Véletlenszerű elemek lehetséges üzemmódjai
     */
    public enum Random {
    	ON, OFF, AUTO
    }
    
    /**
     * A kettévágás véletlenszerűsége
     */
    public static Random randomKettevagas = Random.AUTO;
    
    /**
     * Az útválasztás véletlenszerűsége
     */
    public static Random randomUtvalasztas = Random.AUTO;
    
    /**
     * Játék konstruktora
     */
    public Jatek() { 
    	// az attribútumokat az indit függvényben inicializáljuk a térkép alapján
    }

    /**
     * Visszaadja az ellenségek listáját
     *
     * @return visszaadott ellenségek kollekciója
     */
    public List<Ellenseg> getEllensegek() {
        return ellensegek;
    }
    
    /**
     * Játék indítása
     * A térképfájl betöltése
     * 
     * @param terkep A térképfájl elérési útvonala
     */
    public void indit(String terkep) {
		try {
			Scanner f = new Scanner(new FileReader(terkep));
			
			// szélesség és magasság
			f.findInLine("(\\d),(\\d)");
			MatchResult m = f.match();
			int magassag = Integer.parseInt(m.group(1)), szelesseg = Integer.parseInt(m.group(2));
			f.nextLine();
			
			// cellák, első koordináta a sor, második koordináta az oszlop
			cellak = new Cella[magassag][szelesseg];
			for (int i = 0; i < magassag; i++) {
				String s = f.nextLine();
				
				for (int j = 0; j < szelesseg; j++) {
					Cella c = null;
					
					// cella létrehozása a betűjel alapján
					switch (s.charAt(j)) {
						case 'U':
							c = new Ut();
							break;
						case 'D':
							c = new Domborzat();
							break;
						case 'V':
							c= new VegzetHegye(this);
							break;
					}
					
					c.setPozicio(new Pont(i + 1, j + 1));
					cellak[i][j] = c;
				}
			}
			
			// ellenségek kezdő pozíciói
			kezdoPoziciok = new ArrayList<Ut>();
			
			int k = f.nextInt();
			f.nextLine();
			
			for (int i = 0; i < k; i++) {				
				f.findInLine("(\\d),(\\d)");
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
				sor.findInLine("(\\d),(\\d)");
				MatchResult koordinata = sor.match();
				int x = Integer.parseInt(koordinata.group(1)), y = Integer.parseInt(koordinata.group(2));
				sor.close();
				
				Ut ut = (Ut)cellak[x - 1][y - 1];
				List<Ut> vegpontok = new ArrayList<Ut>();
				
				// a végpontok meghatározása
				for (int j = 1; j < koordinatak.length; j++) {
					sor = new Scanner(koordinatak[j]);
					sor.findInLine("(\\d),(\\d)");
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
			tornyok = new ArrayList<Torony>();
			varazsero = 1000;
			ido = 1;
			
			System.out.format("%s betoltese sikerult, jatek inditasa.%n", terkep);
		} catch (FileNotFoundException e) {
			System.out.format("%s betoltese nem sikerult.%n", terkep);
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
    		System.out.format("%d varazseronk van%n", varazsero);
    		
    		// a játék szereplőit a folytonosság biztosítása céljában nagyobb felbontással léptetjük
    		// először az ellenségek lépnek
    		for (int j = 0; j < 10; j++) {
    			// ellenségek léptetése
    			for (Ellenseg e: ellensegek)
    				e.leptet();
    		}
    		
    		// majd a tornyok tüzelnek
    		for (int j = 0; j < 10; j++) {
    			for (Torony t: tornyok)
    				t.tuzel();
    		}
    		
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
    					
    					// az ellenség létrehozása
	    				Ellenseg e = null;
	    				
	    				// a típus a kezdő pozíciókon ciklikusan váltakozik
	    				switch (melyikKezdoPozicio % 4) {
	    					case 0:
	    						e = new Ember(this);
	    						break;
	    					case 1:
	    						e = new Hobbit(this);
	    						break;
	    					case 2:
	    						e = new Tunde(this);
	    						break;
	    					case 3:
	    						e = new Torp(this);
	    						break;
	    				}
	    				
	    				e.setPozicio(kezdoPozicio);
	    				e.initElet();
	    				ellensegek.add(e);
	    				maradekEllenseg--;
	    				lerakottEllenseg++;
	    				
	    				//System.out.format("jatek letrehozta %s-et%n", e.getObjektumAzonosito());
	    				
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
    			for (Torony t: tornyok)
    				t.kodosit();
    			
    			System.out.println("a tornyokra kod szallt");
    		}
    	}
    }
    
    /**
     * Kapott akadály elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella   ezen a cellán akarjuk elhelyezni az akadályt
     * @param akadaly ezt az akadályt akarjuk elhelyezni
     */
    public void lerakAkadaly(Cella cella, Akadaly akadaly) {
        if (varazsero >= akadaly.getAr() && cella.lerakAkadaly(akadaly)) {
        	varazsero -= 300;
        	System.out.format("Sikerult lerakni az akadalyt az (%d, %d) koordinataju cellara.%n", cella.getPozicio().x, cella.getPozicio().y);
        } else {
        	akadaly.dispose();
        	System.out.format("Az (%d, %d) koordinataju cellara nem lehet akadalyt rakni.%n", cella.getPozicio().x, cella.getPozicio().y);
        }
    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     *
     * @param cella   ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     */
    public void lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        if (varazsero >= sargaKo.getAr() && cella.lerakAkadalyKo(sargaKo)) {
        	varazsero -= 100;
        	System.out.format("Sikerult lerakni a sargakovet az (%d, %d) koordinataju cellan levo akadalyra.%n", cella.getPozicio().x, cella.getPozicio().y);
        } else {
        	sargaKo.dispose();
        	System.out.format("Az (%d, %d) koordinataju cellara nem lehet sargakovet rakni.%n", cella.getPozicio().x, cella.getPozicio().y);
        }
    }

    /**
     * Kapott torony elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella  ezen a cellán akarjuk elhelyezni a tornyot
     * @param torony ezt a tornyot akarjuk elhelyezni
     */
    public void lerakTorony(Cella cella, Torony torony) {
    	if (varazsero >= torony.getAr() && cella.lerakTorony(torony)) {
    		// torony berakása a listába
    		tornyok.add(torony);
    		varazsero -= 400;
    		System.out.format("Sikerult lerakni a tornyot az (%d, %d) koordinataju cellara.%n", cella.getPozicio().x, cella.getPozicio().y);
    	} else {
    		torony.dispose();
        	System.out.format("Az (%d, %d) koordinataju cellara nem lehet tornyot rakni%n", cella.getPozicio().x, cella.getPozicio().y);
    	}
    }
    
    /**
     * Toronykő lerakása egy adott cellán lévő toronyra
     * 
     * @param cella ezen a cellán van a torony
     * @param toronyKo ezt a toronykövet akarjuk rárakni a cellán lévő toronyra
     */
    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {
    	// toronykő típusának meghatározása az üzenet kiírásához
		String ko = null;
		switch (toronyKo.getClass().getName()) {
			case "ZoldKo":
				ko = "zoldkovet";
				break;
			case "KekKo":
				ko = "kekkovet";
				break;
			case "TorpPirosKo":
				ko = "torp piroskovet";
				break;
			case "HobbitPirosKo":
				ko = "hobbit piroskovet";
				break;
			case "TundePirosKo":
				ko = "tunde piroskovet";
				break;
			case "EmberPirosKo":
				ko = "ember piroskovet";
				break;
		}
		
    	if (varazsero >= toronyKo.getAr() && cella.lerakToronyKo(toronyKo)) {
    		varazsero -= 100;
    		System.out.format("Sikerult lerakni a %s az (%d, %d) koordinataju cellan levo toronyra.%n", ko, cella.getPozicio().x, cella.getPozicio().y);
    	} else {
    		toronyKo.dispose();
        	System.out.format("Az (%d, %d) koordinataju cellara nem lehet %s rakni.%n", cella.getPozicio().x, cella.getPozicio().y, ko);
    	}
    }

    /**
     * Meghal egy ellenség.
     * A kapott jutalmat jóva kell írni.
     *
     * @param ellenseg
     * @param jutalom
     */
    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {
    	//System.out.format("%s meghalt%n", ellenseg.getObjektumAzonosito());
    	
    	// varázserő növelése
    	varazsero += jutalom;
    	ellensegek.remove(ellenseg);
    	
        // ha elfogytak az ellenségek, nyertünk
        if (ellensegek.size() == 0 && maradekEllenseg == 0) 
            vege(true);
    }

    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * 
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     * @param ellenseg az ellenség, aki miatt elvesztettük a játékot; megnyert játéknál null
     */
    public void vege(boolean nyertunk, Ellenseg ellenseg) {
        if (nyertunk)
        	System.out.println("minden ellenseg meghalt, nyertunk");
        else
        	System.out.format("%s ralepett a Vegzet Hegyere, vesztettunk%n", ellenseg.getObjektumAzonosito());
    }
    
    /**
     * @see Jatek#vege(boolean, Ellenseg)
     */
    public void vege(boolean nyertunk) {
    	vege(nyertunk, null);
    }
    
    /**
     * Új ellenség lerakása (kettévágáskor).
     * 
     * @param e Az új ellenség
     */
    public void addEllenseg(Ellenseg e) {
    	ellensegek.add(e);
    }
}
