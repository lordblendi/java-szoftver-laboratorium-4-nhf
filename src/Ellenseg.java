public abstract class Ellenseg {
    int elet;
    double helyzet;
    Jatek jatek;
    Ut kovetkezoPozicio;
    Ut pozicio;
    double sebesseg;


    public Ellenseg(Jatek jatek) {
        this.jatek = jatek;
    }

    public void acceptToronyKoSebez(ToronyKo toronyKo) {

    }

    public Ut getPozicio() {
        return pozicio;
    }

    public void setPozicio(Ut pozicio) {
        this.pozicio = pozicio;
    }

    public void initElet() {

    }

    public void setSebesseg(double sebesseg) {
        this.sebesseg = sebesseg;
    }

    public void leptet() {

    }

    public void sebzodik(int sebzes) {

    }

}

