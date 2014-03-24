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
    	String s = KonzolSeged.beolvas("Van mar akadaly az uton?", "[in]");
     	if (s.equals("n")){
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
    	
    	if (jelenlegiUseCase.equals("Jatek leptetese use-case")) {
    		if (!JatekLepteteseUseCase.emberLep) {
	    		KonzolSeged.kiirMegjegyzes("kovetkezoPozicio-n van akadaly es ko is (1)");
	    		KonzolSeged.kiirMegjegyzes("van akadaly, ko nincs (2)");
	    		KonzolSeged.kiirMegjegyzes("nincs akadaly (3)");
	    		String valasz = KonzolSeged.beolvas("A fentiek kozul melyik jatszodjon le?", "[123]");
	    		if (valasz.equals("1")) {
	    			KonzolSeged.kiirFuggvenyHivas("akadaly", "ralep", "hobbit");
	    			akadaly.ralep(ellenseg);
	    		} else if (valasz.equals("2")) {
	    			akadaly.sargaKo = null;
	    			KonzolSeged.kiirFuggvenyHivas("akadaly", "ralep", "hobbit");
	    			akadaly.ralep(ellenseg);
	    		} else {
	    			KonzolSeged.kiirFuggvenyHivas("hobbit", "setSebesseg", "0.7");
	    			ellenseg.setSebesseg(1.0);
	    		}
    		} else {
	        		KonzolSeged.kiirFuggvenyHivas("uj", "setSebesseg", "0.8");
	        		ellenseg.setSebesseg(0.8);
    		}
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
