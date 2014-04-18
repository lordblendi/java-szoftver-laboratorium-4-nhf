public class EmberPirosKo extends ToronyKo {

    public EmberPirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Ember ember) {
        ember.sebzodik(350);
    }

}
