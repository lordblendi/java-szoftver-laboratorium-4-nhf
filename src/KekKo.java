public class KekKo extends ToronyKo {
    public KekKo() {
    }

    /**
     * Beállítja a paraméterül kapott torony hatótávolságát 3.025-re.
     * @param torony
     */
    @Override
    public void setHatotavolsag(Torony torony) {
        torony.setHatotavolsag(3.025);
    }
}
