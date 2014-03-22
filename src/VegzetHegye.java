public class VegzetHegye extends Ut {
    Jatek jatek;

    /**
     * Végzet hegyének konstruktora
     * @param jatek
     */
    public VegzetHegye(Jatek jatek) {
        this.jatek = jatek;
    }

    /**
     * Akadálykő lerakása
     * @param sargaKo elhelyezendő sárgakő
     */
    @Override
    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "lerakAkadaly", "akadaly: Akadaly");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Akadály lerakása
     * @param akadaly
     */
    @Override
    public void lerakAkadaly(Akadaly akadaly) {
//        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "lerakAkadaly", "akadaly: Akadaly");
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ellenség rálép a Végzet Hegyére.
     * Ha rálépett egy ellenség, akkor vége a játéknak.
     * @param ellenseg aki rálép az végzet hegyére
     */
    @Override
    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("jatek", "vege", "false");
        jatek.vege(false);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Visszaadja  következő pozíciót
     * @return nullt ad vissza, mert az ellenség már nem tud hova lépni
     */
    @Override
    public Ut getKovetkezoLepes() {
//        KonzolSeged.kiirFuggvenyHivas("VegzetHegye", "getKovetkezoLepes");
        KonzolSeged.kiirFuggvenyVisszateres("null");
        return null;
    }
}


