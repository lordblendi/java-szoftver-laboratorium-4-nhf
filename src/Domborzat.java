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
    
    /**
     * Ha a domborzaton van torony,
     * akkor lerakja rá a toronykövet.
     * 
     * @param toronyKo ezt rakja rá a toronyra
     */
    @Override
    public void lerakToronyKo(ToronyKo toronyKo) {
    	String valasz = KonzolSeged.beolvas("Van a domborzaton torony?", "[in]");
    	if (valasz.equals("i")) {
    		KonzolSeged.kiirFuggvenyHivas("torony", "lerakToronyKo", "zold");
    		torony.lerakToronyKo(toronyKo);
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }
}
