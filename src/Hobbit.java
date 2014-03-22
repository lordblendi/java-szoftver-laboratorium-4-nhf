public class Hobbit extends Ellenseg {

    /**
     * Hobbit konstruktora
     * @param jatek kapott játék, amelyben a hobbit részt vesz
     */
    public Hobbit(Jatek jatek) {
        super(jatek);
    }

    /**
     * Toronykő segítségével sebzi az ellenséget
     * @param toronyKo
     */
    @Override
    public void acceptToronyKoSebez(ToronyKo toronyKo) {
        super.acceptToronyKoSebez(toronyKo);
    }

    @Override
    public void initElet() {
        super.initElet();
    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes) {
        super.sebzodik(sebzes);
    }
}
