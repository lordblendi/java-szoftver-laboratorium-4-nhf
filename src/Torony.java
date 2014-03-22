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
        KonzolSeged.kiirFuggvenyVisszateres();
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
        String valasz = KonzolSeged.beolvas("varakozas == 0?", "[in]");
        if("i".equals(valasz)){
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

            valasz = KonzolSeged.beolvas("hatotavolsag <= tavolsag?", "[in]");

            if ("i".equals(valasz)) {
                valasz = KonzolSeged.beolvas("toronyKo == null?", "[in]");
                if("i".equals(valasz)){
                    KonzolSeged.kiirFuggvenyHivas("torony", "sebez", "legkozelebbi");
                    sebez(ember);
                }
                else{
                    KonzolSeged.kiirFuggvenyHivas("legkozelebbi", "acceptToronyKoSebez", "toronyKo");
                    ember.acceptToronyKoSebez(toronyKo);
                }

            }
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
