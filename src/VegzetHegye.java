public class VegzetHegye extends Ut {
    Jatek jatek;

    /**
     * Végzet hegyének konstruktora
     * @param jatek
     */
    public VegzetHegye(Jatek jatek) {
        KonzolSeged.kiirKonstruktor("VegzetHegye", "jatek: Jatek");
        this.jatek = jatek;
    }

    /**
     * Akadálykő lerakása
     * @param sargaKo elhelyezendő sárgakő
     */
    @Override
    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "lerakAkadaly", "akadaly: Akadaly");
        KonzolSeged.kiirMegjegyzes("Ez a cella nem út, így nem rakhatsz ra akadalykovett.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Akadály lerakása
     * @param akadaly
     */
    @Override
    public void lerakAkadaly(Akadaly akadaly) {
        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "lerakAkadaly", "akadaly: Akadaly");
        KonzolSeged.kiirMegjegyzes("Ez a cella nem út, így nem rakhatsz ra akadalyt.");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ellenség rálép a Végzet Hegyére.
     * Ha rálépett egy ellenség, akkor vége a játéknak.
     * @param ellenseg aki rálép az végzet hegyére
     */
    @Override
    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "ralep", "ellenseg: Ellenseg");
        jatek.vege(false);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Visszaadja  következő pozíciót
     * @return nullt ad vissza, mert az ellenség már nem tud hova lépni
     */
    @Override
    public Ut getKovetkezoLepes() {
        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "getKovetkezoLepes");
        KonzolSeged.kiirFuggvenyVisszateres("null");
        return null;
    }
}


