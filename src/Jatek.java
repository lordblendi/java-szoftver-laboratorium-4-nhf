import java.util.List;

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
     * A játékos varázsereje
     */
    int varazsero;
    
    /**
     * Tornyok listája
     */
    List<Torony> tornyok;
    
    /**
	 * Referencia a kontrollerre
	 */
	private GameController controller;
    
    /**
     * Konstruktor
     * 
     * @param controller referencia a kontrollerre
     */
    public Jatek(GameController controller) {
    	this.controller = controller;
    }
    
    /**
     * Cellák beállítása
     * 
     * @param cellak cellák
     */
    public void setCellak(Cella[][] cellak) {
    	this.cellak = cellak;
    }
    
    /**
     * Ellenségek beállítása
     * @param ellensegek ellenségek
     */
    public void setEllensegek(List<Ellenseg> ellensegek) {
    	this.ellensegek = ellensegek;
    }
    
    /**
     * Varázserő beállítása
     * 
     * @param varazsero varázserő
     */
    public void setVarazsero(int varazsero) {
    	this.varazsero = varazsero;
    }
    
    /**
     * Varázserő lekérdezése
     * 
     * @return varázserő
     */
    public int getVarazsero() {
    	return varazsero;
    }
    
    /**
     * Tornyok beállítása
     * 
     * @param tornyok tornyok
     */
    public void setTornyok(List<Torony> tornyok) {
    	this.tornyok = tornyok;
    }
    
    /**
     * Az ellenségek léptetése
     */
    public void ellensegLep() {
    	for (int j = 0; j < 10; j++) {
			// ellenségek léptetése
			for (Ellenseg e: ellensegek)
				e.leptet();
		}
    }
    
    /**
     * A tornyok tüzelése
     */
    public void toronyTuzel() {
    	for (int j = 0; j < 10; j++) {
			for (Torony t: tornyok)
				t.tuzel();
		}
    }
    
    /**
     * Köd leeresztése a tornyokra
     */
    public void kodosit() {
    	for (Torony t: tornyok)
			t.kodosit();
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
     * Kapott akadály elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella   ezen a cellán akarjuk elhelyezni az akadályt
     * @param akadaly ezt az akadályt akarjuk elhelyezni
     * @return sikeres-e
     */
    public boolean lerakAkadaly(Cella cella, Akadaly akadaly) {
        if (varazsero >= akadaly.getAr() && cella.lerakAkadaly(akadaly)) {
        	varazsero -= 300;
        	return true;
        } else {
        	akadaly.dispose();
        	controller.alert(String.format("Az (%d, %d) koordinataju cellara nem lehet akadalyt rakni.%n", cella.getPozicio().x, cella.getPozicio().y));
        	return false;
        }
    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     *
     * @param cella   ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     * @return sikeres-e
     */
    public boolean lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        if (varazsero >= sargaKo.getAr() && cella.lerakAkadalyKo(sargaKo)) {
        	varazsero -= 100;
        	return true;
        } else {
        	sargaKo.dispose();
        	controller.alert(String.format("Az (%d, %d) koordinataju cellara nem lehet sargakovet rakni.%n", cella.getPozicio().x, cella.getPozicio().y));
        	return false;
        }
    }

    /**
     * Kapott torony elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella  ezen a cellán akarjuk elhelyezni a tornyot
     * @param torony ezt a tornyot akarjuk elhelyezni
     * @return sikeres-e
     */
    public boolean lerakTorony(Cella cella, Torony torony) {
    	if (varazsero >= torony.getAr() && cella.lerakTorony(torony)) {
    		// torony berakása a listába
    		tornyok.add(torony);
    		varazsero -= 400;
    		return true;
    	} else {
    		torony.dispose();
    		controller.alert(String.format("Az (%d, %d) koordinataju cellara nem lehet tornyot rakni%n", cella.getPozicio().x, cella.getPozicio().y));
    		return false;
    	}
    }
    
    /**
     * Toronykő lerakása egy adott cellán lévő toronyra
     * 
     * @param cella ezen a cellán van a torony
     * @param toronyKo ezt a toronykövet akarjuk rárakni a cellán lévő toronyra
     * @return sikeres-e
     */
    public boolean lerakToronyKo(Cella cella, ToronyKo toronyKo) {
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
    		return true;
    	} else {
    		toronyKo.dispose();
        	controller.alert(String.format("Az (%d, %d) koordinataju cellara nem lehet %s rakni.%n", cella.getPozicio().x, cella.getPozicio().y, ko));
        	return false;
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
    	// varázserő növelése
    	varazsero += jutalom;
    	ellensegek.remove(ellenseg);
    	
    	// a kontroller értesítése
    	controller.meghal(ellenseg, ellensegek.size());
    }
    
    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * 
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     * @param ellenseg az ellenség, aki miatt elvesztettük a játékot; megnyert játéknál null
     */
    public void vege(boolean nyertunk, Ellenseg ellenseg) {
    	controller.vege(nyertunk);
    }
    
    /**
     * Új ellenség lerakása
     * 
     * @param ellenseg az új ellenség
     * @param ut helye
     */
    public void addEllenseg(Ellenseg ellenseg, Ut ut) {
    	ellensegek.add(ellenseg);
    }
    
    /**
     * Kettévágás jelzése
     * 
     * @param ellenseg keletkezett ellenség
     */
    public void kettevagva(Ellenseg ellenseg) {
    	controller.addEllenseg(ellenseg);
    }
    
    /**
     * Adott koordinátájú cellát adja vissza
     * 
     * @param x
     * @param y
     * @return
     */
    public Cella getCella(int i, int j) {
    	if (cellak == null || i > cellak.length || j > cellak[0].length)
    		return null;
    	return cellak[i - 1][j - 1];
    }
    
    /**
     * Jelzi a kontrollernek, ha egy ellenség helyet változtatott
     * 
     * @param ellenseg ellenség
     * @param ut új helye
     */
    public void atlep(Ellenseg ellenseg, Ut ut) {
    	controller.atlep(ellenseg, ut);
    }
}
