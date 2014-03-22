public class Hobbit extends Ellenseg {

    /**
     * Hobbit konstruktora
     * @param jatek kapott játék, amelyben a hobbit részt vesz
     */
    public Hobbit(Jatek jatek) {
        super(jatek);
        KonzolSeged.kiirKonstruktor("Hobbit", "jatek: Jatek");
    }

    @Override
    public void initElet() {
        super.initElet();
    }

    @Override
    public void sebzodik(int sebzes) {
        super.sebzodik(sebzes);
    }
}
