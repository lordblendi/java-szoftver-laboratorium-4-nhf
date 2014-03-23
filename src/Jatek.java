import java.util.Collection;

public class Jatek {
    Collection<Cella> cellak;
    Collection<Ellenseg> ellensegek;
    Collection<Ut> kezdoPoziciok;
    int maradekEllenseg;
    Collection<Torony> tornyok;
    int varazsero;

    /**
     * Játék konstruktora
     */
    public Jatek() {
        
    }

    /**
     * Visszaadja az ellenségek kollekciót
     *
     * @return visszaadott ellenségek kollekciója
     */
    public Collection<Ellenseg> getEllensegek() {
    	KonzolSeged.kiirFuggvenyVisszateres("{ember}");
        return ellensegek;
    }
    
    /**
     * Játék indítása
     */
    public void indit(){
		KonzolSeged.kiirKonstruktor("ut1");
		Ut ut1 = new Ut();
		KonzolSeged.kiirKonstruktor("pont1", "0, 0");
		Pont pont1 = new Pont(0, 0);
		KonzolSeged.kiirKonstruktor("ut2");
		Ut ut2 = new Ut();
		KonzolSeged.kiirKonstruktor("pont2", "0, 1");
		Pont pont2 = new Pont(0, 1);
		
		KonzolSeged.kiirFuggvenyHivas("ut1", "setPozicio", "pont1");
		ut1.setPozicio(pont1);
		KonzolSeged.kiirFuggvenyHivas("ut2", "setPozicio", "pont2");
		ut2.setPozicio(pont2);
		
		KonzolSeged.kiirFuggvenyHivas("ut1", "setKovetkezoLepes", "ut2");
		ut1.setKovetkezoLepes(ut2);
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    /**
     * A játék lépteti az objektumokat
     * 
     * @param ido
     */
    public void leptet(int ido) {
    	String jelenlegiUseCase = KonzolSeged.getAktualisUseCase();
    	
    	if (jelenlegiUseCase.equals("Hobbit leptetese use-case")) {
    		java.util.Iterator<Ellenseg> iterator = ellensegek.iterator();
    		Hobbit hobbit = (Hobbit) iterator.next();
    		KonzolSeged.kiirFuggvenyHivas("hobbit", "leptet");
    		hobbit.leptet();
    	} else if (jelenlegiUseCase.equals("Jatek leptetese use-case")) {
    		KonzolSeged.kiirMegjegyzes("Hobbit léptetése");
    		
    		java.util.Iterator<Torony> iterator = tornyok.iterator();
    		Torony torony = iterator.next();
    		KonzolSeged.kiirFuggvenyHivas("torony", "tuzel");
    		torony.tuzel();
    		
    		String valasz = KonzolSeged.beolvas("maradekEllenseg > 0? (i/n)", "[in]");
    		if (valasz.equals("i")) {
    			KonzolSeged.kiirKonstruktor("uj", "jatek");
    			Ember uj = new Ember(this);
    			Ut kezdoPozicio = kezdoPoziciok.iterator().next();
    			KonzolSeged.kiirFuggvenyHivas("uj", "setPozicio", "kezdoPozicio");
    			uj.setPozicio(kezdoPozicio);
    		}
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }
    /**
     * Kapott akadály elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella   ezen a cellán akarjuk elhelyezni az akadályt
     * @param akadaly ezt az akadályt akarjuk elhelyezni
     */
    public void lerakAkadaly(Cella cella, Akadaly akadaly) {
        KonzolSeged.kiirFuggvenyHivas("akadaly", "getAr");
        akadaly.getAr();
        String s = KonzolSeged.beolvas("van elegendo varazsero az akadaly letetelehez?", "[in]");
        if (s.equals("i")) {
            KonzolSeged.kiirFuggvenyHivas("ut", "lerakAkadaly", "akadaly: Akadaly");
            cella.lerakAkadaly(akadaly);
        } else if (s.equals("n")) {
            akadaly = null;
        } else {
            KonzolSeged.kiirMegjegyzes("hibas valasz");
        }

        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     *
     * @param cella   ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     */
    public void lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("s", "getAr");
        sargaKo.getAr();

        String valasz = KonzolSeged.beolvas("varazsero >= ar?", "[in]");
        if ("i".equals(valasz)) {
            KonzolSeged.kiirFuggvenyHivas("u", "lerakAkadaly", "s");
            cella.lerakAkadalyKo(sargaKo);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Kapott torony elhelyezése a kapott cellán, ha van elég varázserőnk.
     *
     * @param cella  ezen a cellán akarjuk elhelyezni a tornyot
     * @param torony ezt a tornyot akarjuk elhelyezni
     */
    public void lerakTorony(Cella cella, Torony torony) {
        KonzolSeged.kiirFuggvenyHivas("Torony", "getAr");
        torony.getAr();

        String s = KonzolSeged.beolvas("van elegendo varazsero a torony letetelehez?", "[in]");
        if (s.equals("i")) {
            KonzolSeged.kiirFuggvenyHivas("d", "lerakTorony", "torony: Torony");
            cella.lerakTorony(torony);
        } else if (s.equals("n")) {
            torony = null;
        } else {
            KonzolSeged.kiirMegjegyzes("hibas valasz");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    /**
     * Toronykő lerakása egy adott cellán lévő toronyra
     * 
     * @param cella ezen a cellán van a torony
     * @param toronyKo ezt a toronykövet akarjuk rárakni a cellán lévő toronyra
     */
    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {
    	KonzolSeged.kiirFuggvenyHivas("zold", "getAr");
    	toronyKo.getAr();
    	
    	String valasz = KonzolSeged.beolvas("Van eleg varazsero a toronykore? (i/n)", "[in]");    	
    	if (valasz.equals("i")) {
    		KonzolSeged.kiirFuggvenyHivas("domb", "lerakToronyKo", "zold");
    		cella.lerakToronyKo(toronyKo);
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Meghal egy ellenség.
     * A kapott jutalmat jóva kell írni.
     *
     * @param ellenseg
     * @param jutalom
     */
    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {
        String valasz = KonzolSeged.beolvas("Van meg ellenseg a palyan?", "[in]");
        if ("n".equals(valasz)) {
            KonzolSeged.kiirFuggvenyHivas("jatek", "vege", "true");
            vege(true);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     */
    public void vege(boolean nyertunk) {
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
