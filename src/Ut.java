import java.util.ArrayList;
import java.util.Collection;

public class Ut extends Cella {
    Akadaly akadaly = null;
    Collection<Ellenseg> ellensegek;
    Ut kovetkezoLepes;

    /**
     * Út konstruktora
     */
    public Ut() {
        super();
        ellensegek = new ArrayList<Ellenseg>();
    }

    /**
     * Sárgakő elhelyezése az úton
     *
     * @param sargaKo elhelyezendő sárgakő
     */
    @Override
    public void lerakAkadalyKo(SargaKo sargaKo) {
//        KonzolSeged.kiirFuggvenyHivas("Ut", "lerakAkadalyKo", "sargaKo: SargaKo");
        String valasz = KonzolSeged.beolvas("Van az uton akadaly?", "[in]");
        if ("i".equals(valasz)) {
            KonzolSeged.kiirFuggvenyHivas("u", "lerakAkadalyKo", "s");
            boolean b = akadaly.lerakAkadalyKo(sargaKo);
            if(b){
                Ember ember = new Ember(new Jatek());
                KonzolSeged.kiirFuggvenyHivas("u", "ralep", "e");
                ralep(ember);
            }
        } else if ("n".equals(valasz)) {
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

     @Override
    public void lerakAkadaly(Akadaly akadaly) {
    	String s = KonzolSeged.beolvas("Van mar akadaly a cellan?", "[in]");
     	if (s.equals("i")){
     		for (Ellenseg e: ellensegek){
     			KonzolSeged.kiirFuggvenyHivas("akadaly", "ralep", "ember: Ember");
     			akadaly.ralep(e);   	
     		}
     	}
    	 KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ellenség rálép az útra.
     * Ha van rajta akadály akkor az lelassítja,
     * különben az ellenség áthalad rajta lassítás nélkül.
     *
     * @param ellenseg aki rálép az útra
     */
    public void ralep(Ellenseg ellenseg) {
    	String jelenlegiUseCase = KonzolSeged.getAktualisUseCase();
    	
    	if (jelenlegiUseCase.equals("Hobbit leptetese use-case")) {
    		String kerdes = "Az alabbiak kozul melyik jatszodjon le:\n" +
    								"\tkovetkezoPozicio-n van akadaly es ko is (1)\n" +
    								"\tvan akadaly, ko nincs (2)\n" +
    								"\tnincs akadaly (3)";
    		String valasz = KonzolSeged.beolvas(kerdes, "[123]");
    		if (valasz.equals("1")) {
    			KonzolSeged.kiirFuggvenyHivas("akadaly", "ralep", "hobbit");
    			akadaly.ralep(ellenseg);
    		} else if (valasz.equals("2")) {
    			akadaly.sargaKo = null;
    			KonzolSeged.kiirFuggvenyHivas("akadaly", "ralep", "hobbit");
    			akadaly.ralep(ellenseg);
    		} else {
    			KonzolSeged.kiirFuggvenyHivas("hobbit", "setSebesseg", "sebesseg");
    			ellenseg.setSebesseg(1.0);
    		}
    		
    	} else if (jelenlegiUseCase.equals("Jatek leptetese use-case")) {  
    		KonzolSeged.kiirFuggvenyHivas("uj", "setSebesseg", "sebesseg");
    		ellenseg.setSebesseg(0.8);
    	} else {
	        if (akadaly == null) {
	            
	        } else {
	        	KonzolSeged.kiirFuggvenyHivas("a", "ralep", "e");
	            akadaly.ralep(ellenseg);
	        }
    	}
    	
        KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    /**
     * Ellenség lelép az útról.
     * Kikerül az ellenségek kollekcióból.
     * @param ellenseg
     */

    public void lelep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyVisszateres();

    }

    /**
     * Visszaadja a következő cellát,
     * amelyre rá tud lépni az ellenség
     * * @return
     */
    public Ut getKovetkezoLepes() {
    	String jelenlegiUseCase = KonzolSeged.getAktualisUseCase();
    	
    	if (jelenlegiUseCase.equals("Hobbit leptetese use-case")) {
    		KonzolSeged.kiirFuggvenyVisszateres("kovPoz");
    	} else {
//        KonzolSeged.kiirFuggvenyHivas("Ut", "getKovetkezoLepes");
    		KonzolSeged.kiirFuggvenyVisszateres("");
    	}
    	
        return kovetkezoLepes;
    }
    
    /**
     * Beállítja azt az utat,
     * amerre majd az ellenség tovább megy.
     * @param ut következő út
     */
    public void setKovetkezoLepes(Ut ut) {
        this.kovetkezoLepes = ut;
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
