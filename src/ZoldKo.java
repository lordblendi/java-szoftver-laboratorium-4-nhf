public class ZoldKo extends ToronyKo {

    private static int objektumDarabszam = 0;
    private String objektumAzonosito;

    public ZoldKo() {
        objektumAzonosito = "ZoldKo" + ++objektumDarabszam;
    }

    /**
     * Beállítjuk a paraméterül kapott torony várakozási idejét 1.5-re
     * @param torony
     */
    @Override
    public void setVarakozas(Torony torony) {
        torony.setVarakozas(15);
    }


}
