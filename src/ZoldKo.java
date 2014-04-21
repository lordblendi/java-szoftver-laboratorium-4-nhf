public class ZoldKo extends ToronyKo {

	public ZoldKo() {
        objektumAzonosito = "ZoldKo" + ++objektumDarabszam;
    }

    /**
     * Beállítjuk a paraméterül kapott torony várakozási idejét 15-re
     * @param torony
     */
    @Override
    public void setVarakozas(Torony torony) {
        torony.setVarakozas(15);
    }


}
