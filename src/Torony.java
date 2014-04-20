import java.util.List;
import java.util.Random;

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
        String ko = null;
        switch (toronyKo.getClass().getName()) {
            case "ZoldKo":
                ko = "zoldkovet";
                break;
            case "KekKo":
                ko = "kekkovet";
                break;
            case "TorpPirosKo":
                ko = "torp piroskovet";
                break;
            case "HobbitPirosKo":
                ko = "hobbit piroskovet";
                break;
            case "TundePirosKo":
                ko = "tunde piroskovet";
                break;
            case "EmberPirosKo":
                ko = "ember piroskovet";
                break;
        }
        if (this.toronyKo == null) {
            this.toronyKo = toronyKo;
            System.out.format("Sikerult lerakni a %s a (%d, %d) koordinataju cellan levo toronyra.%n", ko, pozicio.getPozicio().x, pozicio.getPozicio().y);
        }
        else {
            System.out.format("A (%d, %d) koordinataju cellan levo toronyra nem lehet %s rakni.%n", pozicio.getPozicio().x, pozicio.getPozicio().y, ko);
        }
    }

    /**
     * A torony sebzi a kapott ellenséget
     *
     * @param ellenseg
     */
    public void sebez(Ellenseg ellenseg) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            ellenseg.sebzodik(250, true);
            System.out.format("%s megsebezte %s-et 250 sebzessel.%n", this.getClass().getName(), ellenseg.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            ellenseg.sebzodik(250, false);
            System.out.format("%s megsebezte %s-et 250 sebzessel.%n", this.getClass().getName(), ellenseg.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            ellenseg.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 250 sebzessel.%n", this.getClass().getName(), ellenseg.getClass().getName());
        }
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
        if(varakozas == 0){
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
                System.out.format("%s-rol a kod felszallt.%n", this.getClass().getName());
            }

            //varakozas visszaallitasa
            if(toronyKo == null){
                this.varakozas=2.0;
            }
            else{
                toronyKo.setVarakozas(this);
            }
        }
        else{
            varakozas--;
        }

    }

    // TODO
    public void kodosit() {
        this.hatotavolsag = 1.375;
    }
}
