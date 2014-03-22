public class Torony {
    int hatotavolsag;
    Jatek jatek;
    Domborzat pozicio;
    ToronyKo toronyKo;
    int varakozas;

    public Torony(Jatek jatek) {
        this.jatek = jatek;
    }

    public int getAr() {
        return 0;
    }

    public void lerakToronyKo(ToronyKo toronyKo) {

    }

    /**
     * A torony sebzi a kapott ellenséget
     * @param ellenseg
     */
    public void sebez(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("ellenseg", "sebzodik", "sebzes");
        ellenseg.sebzodik(10);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void setPozicio(Domborzat domborzat) {
        this.pozicio = domborzat;
    }

    public void setHatotavolsag(int hatotavolsag) {
        this.hatotavolsag = hatotavolsag;
    }

    public void setVarakozas(int varakozas) {
        this.varakozas = varakozas;
    }

    /**
     * A torony tüzel az összes ellenségre.
     * Megnézi, hogy az ellenség hatótávolságon belül van-e.
     * Ha azon belül van, akkor ha van rajta toronykő,
     * akkor annak segítségével sebzi,
     * különben a saját sebez függvényét hívja meg.
     */
    public void tuzel() {
        ToronyKo toronyKo = new EmberPirosKo();
        Ut ut = new Ut();
        Jatek jatek = new Jatek();
        Domborzat domborzat = new Domborzat();
        Ellenseg ember = new Ember(jatek);
        ember.pozicio = ut;

        KonzolSeged.kiirFuggvenyHivas("jatek", "getEllensegek");
        jatek.getEllensegek();

        KonzolSeged.kiirFuggvenyHivas("ember", "getPozicio");
        ember.getPozicio();

        KonzolSeged.kiirFuggvenyHivas("ut", "getTavolsag", "domborzat");
        double d = ut.getTavolsag(domborzat);

        String valasz = KonzolSeged.beolvas("Az ellenseg hatotavolsagon belul van?", "[in]");

        if ("i".equals(valasz)) {
            valasz = KonzolSeged.beolvas("Van ToronyKo a tornyon?", "[in]");
            if("n".equals(valasz)){
                KonzolSeged.kiirFuggvenyHivas("torony", "sebez", "legkozelebbi");
                sebez(ember);
            }
            else{
                KonzolSeged.kiirFuggvenyHivas("legkozelebbi", "acceptToronyKoSebez", "toronyKo");
                ember.acceptToronyKoSebez(toronyKo);
            }


            valasz = KonzolSeged.beolvas("Meghalt az ellenseg?", "[in]");
            if("n".equals(valasz)){
            }
            else{
                KonzolSeged.kiirFuggvenyHivas("jatek", "meghalEllenseg", "legkozelebbi");
                jatek.meghalEllenseg(ember,100);
            }

        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
