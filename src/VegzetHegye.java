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
        super.lerakAkadalyKo(sargaKo);
    }

    /**
     * Akadály lerakása
     * @param akadaly
     */
    @Override
    public void lerakAkadaly(Akadaly akadaly) {
    	super.lerakAkadaly(akadaly);
    }

    /**
     * Ellenség rálép a Végzet Hegyére.
     * Ha rálépett egy ellenség, akkor vége a játéknak.
     * @param ellenseg aki rálép az végzet hegyére
     */
    @Override
    public void ralep(Ellenseg ellenseg) {
        super.ralep(ellenseg);
    }

    /**
     * Visszaadja  következő pozíciót
     * @return nullt ad vissza, mert az ellenség már nem tud hova lépni
     */
    @Override
    public Ut getKovetkezoLepes() {
        return null;
    }
}


