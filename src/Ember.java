public class Ember extends Ellenseg {

    /**
     * Ember konstruktora
     * @param jatek kapott játék, amelyben az ember részt vesz
     */
    public Ember(Jatek jatek) {
        super(jatek);
        KonzolSeged.kiirKonstruktor("Ember", "jatek: Jatek");
    }

    @Override
    public void initElet() {

    }

    @Override
    public void sebzodik(int sebzes) {

    }
}
