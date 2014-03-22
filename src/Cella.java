public abstract class Cella {
    Pont pozicio;

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
        KonzolSeged.kiirFuggvenyVisszateres("tavolsag");
        return d;
    }

    public void lerakAkadaly(Akadaly akadaly) {

    }

    /**
     * Sárgakő elhelyezése a cellán
     *
     * @param sargaKo elhelyezendő sárgakő
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakTorony(Torony torony) {

    }

    public void lerakToronyKo(ToronyKo toronyKo) {

    }
}
