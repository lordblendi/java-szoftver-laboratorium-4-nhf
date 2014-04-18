public class HobbitPirosKo extends ToronyKo {

    public HobbitPirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Hobbit hobbit) {
        hobbit.sebzodik(350);
    }


}
