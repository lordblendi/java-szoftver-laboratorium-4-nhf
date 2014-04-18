public class ZoldKo extends ToronyKo {

    public ZoldKo() {
    }

    /**
     * Beállítjuk a paraméterül kapott torony várakozási idejét 1.5-re
     * @param torony
     */
    @Override
    public void setVarakozas(Torony torony) {
        torony.setVarakozas(1.5);
    }


}
