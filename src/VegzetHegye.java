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
     * 
     * @param sargaKo elhelyezendő sárgakő
     * @return sikeres-e
     */
    @Override
    public boolean lerakAkadalyKo(SargaKo sargaKo) {
    	return false;
    }

    /**
     * Akadály lerakása
     * 
     * @param akadaly
     * @return sikeres-e
     */
    @Override
    public boolean lerakAkadaly(Akadaly akadaly) {
    	return false;
    }

    /**
     * Ellenség rálép a Végzet Hegyére.
     * Ha rálépett egy ellenség, akkor vége a játéknak.
     * @param ellenseg aki rálép az végzet hegyére
     */
    @Override
    public void ralep(Ellenseg ellenseg) {
    	jatek.vege(false, ellenseg);
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


