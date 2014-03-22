public class Pont {
    int x;
    int y;

    /**
     * Pont konstruktora
     * @param x x koordináta
     * @param y y koordináta
     */
    public Pont(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Két pont közötti távolságot adja vissza
     * @param pont a kapott pont távolságát kell megkapni
     * @return két pont távolsága
     */
    public double getTavolsag(Pont pont) {
        KonzolSeged.kiirFuggvenyVisszateres("tavolsag");
        return 100.0;
    }
}
