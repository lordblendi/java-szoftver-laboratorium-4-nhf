public class Domborzat extends Cella {
    Torony torony;

    public Domborzat() {
    }

    /**
     * Kapott torony eltárolása, ha még nem tárolunk eggyet sem.
     * @param torony ezt a tornyot akarjuk eltárolni
     */
    @Override
    public boolean  lerakTorony(Torony torony) {
    	String s = KonzolSeged.beolvas("Van mar torony a cellan?", "[in]");
    	if (s.equals("i")){
	    	KonzolSeged.kiirFuggvenyVisszateres("false: boolean");	
	    	return false;    	
    	}
	    else if (s.equals("n")){
	    	KonzolSeged.kiirFuggvenyHivas("torony", "setPozicio", "d: Domborzat");
	    	torony.setPozicio(this);
	    	KonzolSeged.kiirFuggvenyVisszateres("true: boolean");
	    	return true;
    	}
    	else{
    		KonzolSeged.kiirMegjegyzes("hibas valasz");
    		KonzolSeged.kiirFuggvenyVisszateres("false: boolean");
    		return false;
    	}
    	
    }

    @Override
    public void lerakToronyKo(ToronyKo toronyKo) {

    }
}
