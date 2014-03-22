public abstract class Ellenseg {
    int elet;
    double helyzet;
    Jatek jatek;
    Ut kovetkezoPozicio;
    Ut pozicio;
    double sebesseg;

    /**
     * Ellenség konstruktora
     *
     * @param jatek játék, melyben az ellenség részt vesz.
     */
    public Ellenseg(Jatek jatek) {
        this.jatek = jatek;
    }

    /**
     * Toronykő segítségével sebzi az ellenséget
     * @param toronyKo
     */
    public void acceptToronyKoSebez(ToronyKo toronyKo) {

    }

    /**
     * aktuális pozíció visszaadása
     * @return aktuális pozíció
     */
    public Ut getPozicio() {
        KonzolSeged.kiirFuggvenyVisszateres("ut");
        return pozicio;
    }

    /**
     * Beállítja az új pozíciót,
     * valamit az új következő pozíciót.
     *
     * @param pozicio kovetkezo pozicio
     */
    public void setPozicio(Ut pozicio) {
//        KonzolSeged.kiirFuggvenyHivas("Ellenseg", "setPozicio", "pozicio: Ut");
//        KonzolSeged.kiirMegjegyzes("Beallitodik az uj pozicio, es a kovetkezo pozicio.");
        KonzolSeged.kiirFuggvenyHivas("ut", "getKovetkezoLepes");
        kovetkezoPozicio = pozicio.getKovetkezoLepes();
        this.pozicio = pozicio;

        KonzolSeged.kiirFuggvenyHivas("kovetkezoPozicio", "ralep", "hobbit");
        pozicio.ralep(this);

        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void initElet() {

    }

    /**
     * Ellenség sebességének a beállítása a kapott értékre
     *
     * @param sebesseg beállítandó sebesség
     */
    public void setSebesseg(double sebesseg) {
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
        String valasz = KonzolSeged.beolvas("helyzet >= 1.0?", "[in]");
        if("i".equals(valasz)){
            KonzolSeged.kiirFuggvenyHivas("ut", "lelep", "hobbit");
            pozicio.lelep(this);

            KonzolSeged.kiirFuggvenyHivas("hobbit", "setPozicio", "kovetkezoPozicio");
            setPozicio(kovetkezoPozicio);

        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * ennyivel sebződik az ellenség
     * @param sebzes
     */
    public void sebzodik(int sebzes) {

        String valasz = KonzolSeged.beolvas("Meghalt az ellenseg?", "[in]");
        if("n".equals(valasz)){
        }
        else{
            KonzolSeged.kiirFuggvenyHivas("jatek", "meghalEllenseg", "legkozelebbi");
            jatek.meghalEllenseg(this,100);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

}

