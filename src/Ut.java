import java.util.Collection;

public class Ut extends Cella {
    Akadaly akadaly = null;
    Collection<Ellenseg> ellensegek;
    Ut kovetkezoLepes;

    /**
     * Út konstruktora
     */
    public Ut() {
        super();
        KonzolSeged.kiirKonstruktor("Ut");
    }

    /**
     * Sárgakő elhelyezése az úton
     *
     * @param sargaKo elhelyezendő sárgakő
     */
    @Override
    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("Ut", "lerakAkadalyKo", "sargaKo: SargaKo");
        String valasz = KonzolSeged.beolvas("Van az uton akadaly?", "[in]");
        if ("i".equals(valasz)) {
            akadaly.lerakAkadalyKo(sargaKo);
        } else if ("n".equals(valasz)) {
            KonzolSeged.kiirMegjegyzes("SargaKovet csak olyan utra lehet rakni, amin mar van akadaly.");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }


    @Override
    public void lerakAkadaly(Akadaly akadaly) {
        super.lerakAkadaly(akadaly);
    }

    /**
     * Ellenség rálép az útra. Ha van rajta akadály akkor az lelassítja, különben az ellenség áthalad rajta lassítás nélkül.
     *
     * @param ellenseg aki rálép az útra
     */
    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("Ut", "ralep", "ellenseg: Ellenseg");
        if (akadaly == null) {
            KonzolSeged.kiirMegjegyzes("Az uton nincs akadaly, igy az ellenseg lassitas nelkul halad.");
        } else {
            akadaly.ralep(ellenseg);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lelep(Ellenseg ellenseg) {

    }

    public Ut getKovetkezoLepes() {
        return kovetkezoLepes;
    }

    public void setKovetkezoLepes(Ut ut) {
        this.kovetkezoLepes = ut;
    }
}
