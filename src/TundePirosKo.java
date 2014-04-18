public class TundePirosKo extends ToronyKo {

    public TundePirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Tunde tunde) {
        tunde.sebzodik(350);
    }

}
