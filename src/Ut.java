import java.util.Collection;

public class Ut extends Cella {
    Akadaly akadaly;
    Collection<Ellenseg> ellensegek;
    Ut kovetkezoLepes;

    public Ut() {
    }

    @Override
    public void lerakAkadalyKo(SargaKo sargaKo) {
        super.lerakAkadalyKo(sargaKo);
    }

    @Override
    public void lerakAkadaly(Akadaly akadaly) {
        super.lerakAkadaly(akadaly);
    }

    public void ralep(Ellenseg ellenseg) {

    }

    public void lelep(Ellenseg ellenseg) {

    }

    public Ut getKovetkezoLepes() {
        return kovetkezoLepes;
    }

    public void setKovetkezoLepes(Ut ut) {
        this.kovetkezoLepes = ut;
    }
}
