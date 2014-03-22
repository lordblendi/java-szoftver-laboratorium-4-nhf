import java.util.Collection;

public class Jatek {
    Collection<Cella> cellak;
    Collection<Ellenseg> ellensegek;
    Collection<Ut> kezdoPoziciok;
    int maradekEllenseg;
    Collection<Torony> tornyok;
    int varazsero;

    /**
     * Játék konstruktora
     */
    public Jatek() {
        KonzolSeged.kiirKonstruktor("Jatek");
    }

    public Collection<Ellenseg> getEllensegek() {
        return ellensegek;
    }

    public void indit(){

    }

    public void leptet(int ido) {

    }

    public void lerakAkadaly(Cella cella, Akadaly akadaly) {

    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     * @param cella ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     */
    public void lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("Jatek", "larakAkadalyKo", "cella: Cella, sargaKo: SargaKo");
        cella.lerakAkadalyKo(sargaKo);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakTorony(Cella cella, Torony torony) {

    }

    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {

    }

    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {

    }

    public void vege(boolean nyertunk) {

    }
}
