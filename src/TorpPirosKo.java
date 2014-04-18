public class TorpPirosKo extends ToronyKo {

    public TorpPirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Torp torp) {
        torp.sebzodik(350);
    }

}
