import java.util.List;
import java.util.Random;

public class Torony {
    private static int objektumDarabszam = 0;
    private double hatotavolsag;
    private Jatek jatek;
    private Domborzat pozicio;
    private ToronyKo toronyKo;
    private double varakozas;
    private String objektumAzonosito;

    public Torony(Jatek jatek) {
        this.jatek = jatek;
        this.hatotavolsag = 2.75;
        this.varakozas = 0;
        this.toronyKo = null;
        pozicio=null;
        objektumAzonosito = "Torony" + ++objektumDarabszam;
    }

    /**
     * Torony árának lekérdezése
     * @return  ára, 400 varázserő
     */
    public int getAr() {
        return 400;
    }

    /**
     * Toronykő lerakása a toronyra.
     *
     * @param toronyKo ezt rakja rá a toronyra
     * @return sikeres-e
     */
    public boolean lerakToronyKo(ToronyKo toronyKo) {
        if (this.toronyKo == null) {
            this.toronyKo = toronyKo;
            //Beállítjuk a hatótávolságot, hátha kékkő került ránk.
            this.toronyKo.setHatotavolsag(this);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * A torony sebzi a kapott ellenséget
     *
     * @param ellenseg
     */
    public void sebez(Ellenseg ellenseg) {
        ellenseg.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
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
        //csökkentjük a várakozás értékét
        varakozas--;
        //ha a varakozás 0, akkor lőhetünk
        if(varakozas <= 0){
            //kiválasztjuk a legközelebbi ellenséget
            //megnézzük, hogy hatótávolságon belüle van-e ellenség
            Ellenseg legkozelebbiEllenseg = null;
            double legkozelebbi = this.hatotavolsag;
            for (Ellenseg ellenseg : jatek.getEllensegek()) {
                double tavolsag = ellenseg.getPozicio().getTavolsag(this.pozicio);
                if (tavolsag < legkozelebbi) {
                    legkozelebbi = tavolsag;
                    legkozelebbiEllenseg = ellenseg;
                }
            }
            //ha van hatótávolságon belül ellenség, akkor megsebezzük
            //attól függően, hogy van-e a tornyon toronykő
            if (legkozelebbiEllenseg != null) {
                if (toronyKo == null) {
                    sebez(legkozelebbiEllenseg);
                } else {
                    legkozelebbiEllenseg.acceptToronyKoSebez(toronyKo);
                }

	            //Köd felszáll, beállítjuk a hatótávolságot a megfelelő értékre
	            if(this.hatotavolsag == 1.375){
	                if(toronyKo == null){
	                    this.hatotavolsag=2.75;
	                }
	                else{
	                    toronyKo.setHatotavolsag(this);
	                }
	            }
	            
	            //varakozas visszaallitasa
	            if(toronyKo == null){
	                this.varakozas=20;
	            }
	            else{
	                toronyKo.setVarakozas(this);
	            }
            }
        }
    }

    /**
     * Köd esetén beállítja a hatótávolságot az alap érték felére.
     */
    public void kodosit() {
        this.hatotavolsag = 1.375;
    }

    /**
     * Visszaadja az objektum azonosítóját.
     *
     * @return objektum azonosítója
     */
    public String getObjektumAzonosito() {
        return objektumAzonosito;
    }
    
    /**
     * Objektum törlése, ha nem sikerült lerakni.
     */
    public void dispose() {
    	objektumDarabszam--;
    }
}
