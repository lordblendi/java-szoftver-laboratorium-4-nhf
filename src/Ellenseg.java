public abstract class Ellenseg {
    int elet;
    double helyzet;
    Jatek jatek;
    Ut kovetkezoPozicio;
    Ut pozicio;
    double sebesseg;

    /**
     * Ellenség konstruktora
     * @param jatek játék, melyben az ellenség részt vesz.
     */
    public Ellenseg(Jatek jatek) {
        KonzolSeged.kiirKonstruktor("Ellenseg", "jatek: Jatek");
        this.jatek = jatek;
    }

    public void acceptToronyKoSebez(ToronyKo toronyKo) {

    }

    public Ut getPozicio() {
        return pozicio;
    }

    /**
     * Beállítja az új pozíciót,
     * valamit az új következő pozíciót.
     * @param pozicio kovetkezo pozicio
     */
    public void setPozicio(Ut pozicio) {
        KonzolSeged.kiirFuggvenyHivas("Ellenseg", "setPozicio", "pozicio: Ut");
        KonzolSeged.kiirMegjegyzes("Beallitodik az uj pozicio, es a kovetkezo pozicio.");
        kovetkezoPozicio = pozicio.getKovetkezoLepes();
        this.pozicio = pozicio;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void initElet() {

    }

    /**
     * Ellenség sebességének a beállítása a kapott értékre
     * @param sebesseg beállítandó sebesség
     */
    public void setSebesseg(double sebesseg) {
        KonzolSeged.kiirFuggvenyHivas("Ellenseg", "setSebesseg", "sebesseg: double");
        KonzolSeged.kiirMegjegyzes("A sebesseg beallitasa sikeres.");
        this.sebesseg = sebesseg;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Ellenség léptetése.
     * Ha a pozíciói >1, akkor lelép a jelenlegi pozícióról.
     * Beállítja az új pocíviónak a következő pozíciót.
     * Rálép az új pocícióra.
     */
    public void leptet() {
        KonzolSeged.kiirFuggvenyHivas("Ellenseg", "leptet");
        KonzolSeged.kiirMegjegyzes("Az ellenseg vegighaladt az uton. Ralep a kovetkezo cellara");
        pozicio.lelep(this);
        setPozicio(kovetkezoPozicio);
        pozicio.ralep(this);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void sebzodik(int sebzes) {

    }

}

