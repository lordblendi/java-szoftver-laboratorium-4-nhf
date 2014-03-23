public abstract class Cella {
    Pont pozicio;

    /**
     * Cella konstruktora
     */
    protected Cella() {

    }

    public void setPozicio(Pont pozicio) {
        this.pozicio = pozicio;
        KonzolSeged.kiirFuggvenyVisszateres();
    }


    /**
     * visszaadja az aktuális pozíciót
     *
     * @return aktuális pozíció
     */
    public Pont getPozicio() {
        KonzolSeged.kiirFuggvenyVisszateres("pont");
        return new Pont(1,1);
//        return pozicio;
    }

    /**
     * Ezen cella és a kapott cella közötti
     * távolságot adja vissza
     * @param cella ettől mért távolságot adja vissza
     * @return távolság
     */
    public double getTavolsag(Cella cella) {
        KonzolSeged.kiirFuggvenyHivas("domborzat", "getPozicio");
        Pont pozicio = cella.getPozicio();
        KonzolSeged.kiirFuggvenyHivas("pozicio", "getTavolsag", "pont");
        double d = pozicio.getTavolsag(new Pont(1,1));
        KonzolSeged.kiirFuggvenyVisszateres("2.0");
        return d;
    }

    public void lerakAkadaly(Akadaly akadaly) {
      	KonzolSeged.kiirMegjegyzes("Ez a cella nem ut, igy nem rakhatsz ra akadalyt.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Sárgakő elhelyezése a cellán
     *
     * @param sargaKo elhelyezendő sárgakő
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {
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
