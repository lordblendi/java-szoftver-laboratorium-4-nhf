public abstract class Cella {
    protected  Pont pozicio;

    /**
     * Cella konstruktora
     */
    protected Cella() {

    }

    public void setPozicio(Pont pozicio) {
        this.pozicio = pozicio;
    }


    /**
     * visszaadja az aktuális pozíciót
     *
     * @return aktuális pozíció
     */
    public Pont getPozicio() {
    	return pozicio;
    }

    /**
     * Ezen cella és a kapott cella közötti
     * távolságot adja vissza
     * @param cella ettől mért távolságot adja vissza
     * @return távolság
     */
    public double getTavolsag(Cella cella) {
       return pozicio.getTavolsag(cella.getPozicio());
    }
    
    
    /**
     * Akadály elhelyezése a cellán
     *
     * @param akadaly az elhelyezendő Akadály
     * @return sikeres-e
     */
    public boolean lerakAkadaly(Akadaly akadaly) {
    	return false;
    }

    /**
     * Sárgakő elhelyezése a cellán
     *
     * @param sargaKo elhelyezendő sárgakő
     * @return sikeres-e
     */
    public boolean lerakAkadalyKo(SargaKo sargaKo) {
    	return false;
    }
    /**
     * Torony elhelyezése a cellán
     *
     * @param torony az elhelyezendő torony
     * @return sikeres-e
     */
    public boolean lerakTorony(Torony torony) {
        return false;
    }

    /**
     * Toronykő elhelyezése a cellán.
     * 
     * @param toronyKo
     * @return sikeres-e
     */
    public boolean lerakToronyKo(ToronyKo toronyKo) {
    	return false;
    }
}
