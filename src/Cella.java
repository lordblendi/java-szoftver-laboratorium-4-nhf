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
      	KonzolSeged.kiirMegjegyzes("Ez a cella nem ut, igy nem rakhatsz ra akadalyt.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Sárgakő elhelyezése a cellán
     * @param sargaKo elhelyezendő sárgakő
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("Cella", "lerakAkadaly", "akadaly: Akadaly");
        KonzolSeged.kiirMegjegyzes("Ez a cella nem ut, igy nem rakhatsz ra akadalykovet.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public boolean lerakTorony(Torony torony) {
    	KonzolSeged.kiirMegjegyzes("Ez a cella nem domborzat, így nem rakhatsz ra tornyot.");
        KonzolSeged.kiirFuggvenyVisszateres();
        return false;
    }

    public void lerakToronyKo(ToronyKo toronyKo) {

    }
}
