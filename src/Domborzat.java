public class Domborzat extends Cella {
    private Torony torony = null;

    public Domborzat() {
    }

    /**
     * Kapott torony eltárolása, ha még nem tárolunk eggyet sem.
     * @param torony ezt a tornyot akarjuk eltárolni
     * @return sikeres-e
     */
    @Override
    public boolean lerakTorony(Torony torony) {
    	if (this.torony != null){
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
     * @return sikeres-e
     */
    @Override
    public boolean lerakToronyKo(ToronyKo toronyKo) {
    	if (torony != null)
    	{
    		return torony.lerakToronyKo(toronyKo);
    	}
    	return false;
    }
}
