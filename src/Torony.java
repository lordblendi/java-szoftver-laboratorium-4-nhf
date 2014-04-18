import java.util.List;

public class Torony {
    double hatotavolsag;
    Jatek jatek;
    Domborzat pozicio;
    ToronyKo toronyKo;
    double varakozas;

    public Torony(Jatek jatek) {
        this.jatek = jatek;
        this.hatotavolsag = 2.75;
        this.varakozas = 2.0;
    }

    /**
     * Torony árának lekérdezése
     */
    public int getAr() {
        return 400;
    }

    /**
     * Toronykő lerakása a toronyra.
     *
     * @param toronyKo ezt rakja rá a toronyra
     */
    public void lerakToronyKo(ToronyKo toronyKo) {
        if (this.toronyKo == null) {
            this.toronyKo = toronyKo;
        }
    }

    /**
     * A torony sebzi a kapott ellenséget
     *
     * @param ellenseg
     */
    public void sebez(Ellenseg ellenseg) {
        ellenseg.sebzodik(250);
    }

    /**
     * Torony pozíciójának beállítása
     *
     * @param domborzat a torony ezen a Domborzaton lesz
     */
    public void setPozicio(Domborzat domborzat) {
        this.pozicio = domborzat;
    }

    /**
     * Torony hatótávolságának beállítása
     *
     * @param hatotavolsag torony hatótávolsága
     */
    public void setHatotavolsag(double hatotavolsag) {
        this.hatotavolsag = hatotavolsag;
    }

    /**
     * Torony tüzelési gyakoriságának beállítása.
     *
     * @param varakozas tüzelési gyakoriság
     */
    public void setVarakozas(double varakozas) {
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
        Ellenseg legkozelebbiEllenseg = null;
        double legkozelebbi = this.hatotavolsag;
        for (Ellenseg ellenseg : jatek.getEllensegek()) {
            double tavolsag = ellenseg.getPozicio().getTavolsag(this.pozicio);
            if (tavolsag < legkozelebbi) {
                legkozelebbi = tavolsag;
                legkozelebbiEllenseg = ellenseg;
            }
        }

        if (legkozelebbiEllenseg != null) {
            if (toronyKo == null) {
                sebez(legkozelebbiEllenseg);
            } else {
                legkozelebbiEllenseg.acceptToronyKoSebez(toronyKo);
            }

        }
        if(this.hatotavolsag == 1.375){
            this.hatotavolsag=2.75;
        }

    }

    // TODO
    public void kodosit() {
        this.hatotavolsag = 1.375;
    }
}
