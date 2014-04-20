public class Domborzat extends Cella {
    private Torony torony = null;

    public Domborzat() {
    }

    /**
     * Kapott torony eltárolása, ha még nem tárolunk eggyet sem.
     * @param torony ezt a tornyot akarjuk eltárolni
     */
    @Override
    public boolean  lerakTorony(Torony torony) {
    	if (torony != null){
	    	return false;    	
    	}
	    else{
	    	this.torony=torony;
	    	this.torony.setPozicio(this);
	    	
	    	return true;
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
    	if (torony != null)
    	{
    		torony.lerakToronyKo(toronyKo);
    	}
    }
}
