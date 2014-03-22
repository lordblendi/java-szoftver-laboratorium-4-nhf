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
        KonzolSeged.kiirFuggvenyHivas("cella", "lerakAkadaly", "sargaKo");
        cella.lerakAkadalyKo(sargaKo);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakTorony(Cella cella, Torony torony) {

    }

    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {

    }

    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {

    }

    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     */
    public void vege(boolean nyertunk) {
//        KonzolSeged.kiirFuggvenyHivas("Jatek", "vege", "nyertunk: boolean");
        if(nyertunk){
            KonzolSeged.kiirMegjegyzes("A jateknak vege. A jatekos nyert.");
        }
        else{
            KonzolSeged.kiirMegjegyzes("A jateknak vege. A jatekos vesztett.");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
