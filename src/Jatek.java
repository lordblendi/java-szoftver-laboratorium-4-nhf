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
    }

    /**
     * Visszaadja az ellenségek kollekciót
     *
     * @return visszaadott ellenségek kollekciója
     */
    public Collection<Ellenseg> getEllensegek() {
        KonzolSeged.kiirFuggvenyVisszateres("{ember}");
        return ellensegek;
    }

    public void indit() {

    }

    public void leptet(int ido) {

    }

    public void lerakAkadaly(Cella cella, Akadaly akadaly) {

    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     *
     * @param cella   ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     */
    public void lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("s", "getAr");
        sargaKo.getAr();

        KonzolSeged.kiirFuggvenyHivas("u", "lerakAkadaly", "s");
        cella.lerakAkadalyKo(sargaKo);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakTorony(Cella cella, Torony torony) {

    }

    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {

    }

    /**
     * Meghal egy ellenség.
     * A kapott jutalmat jóva kell írni.
     *
     * @param ellenseg
     * @param jutalom
     */
    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {
        String valasz = KonzolSeged.beolvas("Van meg ellenseg a palyan?", "[in]");
        if ("n".equals(valasz)) {
            KonzolSeged.kiirFuggvenyHivas("jatek", "vege", "true");
            vege(true);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     *
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     */
    public void vege(boolean nyertunk) {
//        KonzolSeged.kiirFuggvenyHivas("Jatek", "vege", "nyertunk: boolean");
        if (nyertunk) {
        } else {
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
