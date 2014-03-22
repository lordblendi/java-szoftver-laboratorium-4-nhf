public class Tunde extends Ellenseg {

    /**
     * Tünde konstruktora.
     * @param jatek ebben a játékban szerepel a tünde.
     */
    public Tunde(Jatek jatek) {
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
