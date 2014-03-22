public abstract class Ellenseg {
    int elet;
    double helyzet;
    Jatek jatek;
    Ut kovetkezoPozicio;
    Ut pozicio;
    double sebesseg;


    public Ellenseg(Jatek jatek) {
        KonzolSeged.kiirKonstruktor("Ellenseg", "jatek: Jatek");
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
        KonzolSeged.kiirFuggvenyHivas("Ellenseg", "setSebesseg", "sebesseg: double");
        this.sebesseg = sebesseg;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void leptet() {

    }

    public void sebzodik(int sebzes) {

    }

}

