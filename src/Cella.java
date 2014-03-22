public abstract class Cella {
    Pont pozicio;

    /**
     * Cella konstruktora
     */
    protected Cella() {
        KonzolSeged.kiirKonstruktor("Cella");
    }

    public void setPozicio(Pont pozicio) {
        this.pozicio = pozicio;
    }

    public Pont getPozicio() {
        return pozicio;
    }

    public double getTavolsag(Cella cella) {
    	return 0;
    }

    public void lerakAkadaly(Akadaly akadaly) {

    }

    /**
     * Sárgakő elhelyezése a cellán
     * @param sargaKo elhelyezendő sárgakő
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {

        KonzolSeged.kiirMegjegyzes("Ez a cella nem út, így nem rakhatsz ra akadalykovet.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakTorony(Torony torony) {

    }

    public void lerakToronyKo(ToronyKo toronyKo) {

    }
}
