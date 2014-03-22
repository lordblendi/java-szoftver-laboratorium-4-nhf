public class Ember extends Ellenseg {

    /**
     * Ember konstruktora
     * @param jatek kapott játék, amelyben az ember részt vesz
     */
    public Ember(Jatek jatek) {
        super(jatek);
    }

    /**
     * Toronykő segítségével sebzi az ellenséget
     * @param toronyKo
     */
    @Override
    public void acceptToronyKoSebez(ToronyKo toronyKo) {
        KonzolSeged.kiirFuggvenyHivas("toronyKo", "sebez", "legkozelebbi");
        toronyKo.sebez(this);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    @Override
    public void initElet() {

    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes) {
       KonzolSeged.kiirFuggvenyVisszateres();
    }
}
