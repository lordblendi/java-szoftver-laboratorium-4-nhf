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
     */
    public void lerakAkadaly(Akadaly akadaly) {
    }

    /**
     * Sárgakő elhelyezése a cellán
     *
     * @param sargaKo elhelyezendő sárgakő
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {
    }
    /**
     * Toronx elhelyezése a cellán
     *
     * @param torony az elhelyezendő torony
     */
    public boolean lerakTorony(Torony torony) {
        return false;
    }

    public void lerakToronyKo(ToronyKo toronyKo) {
    }
}
