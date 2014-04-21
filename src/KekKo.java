public class KekKo extends ToronyKo {

    private static int objektumDarabszam = 0;
    private String objektumAzonosito;

    public KekKo() {
        objektumAzonosito = "KekKo" + ++objektumDarabszam;
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
