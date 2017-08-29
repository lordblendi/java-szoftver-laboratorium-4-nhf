import java.util.Random;

public abstract class ToronyKo {

    protected static int objektumDarabszam = 0;
    protected String objektumAzonosito;

    /**
     * Konstruktor
     */
    public ToronyKo() {
    }
    
    /**
     * Toronykő árának lekérdezése
     */
    public int getAr() {
        return 100;
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param ember sebzendő ellenség
     */
    public void sebez(Ember ember) {
        ember.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param hobbit sebzendő ellenség
     */
    public void sebez(Hobbit hobbit) {
        hobbit.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param torp sebzendő ellenség
     */
    public void sebez(Torp torp) {
        torp.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param tunde sebzendő ellenség
     */
    public void sebez(Tunde tunde) {
        tunde.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
    }

    /**
     * Torony hatótávolságának beállítása
     * 
     * @param torony
     */
    public void setHatotavolsag(Torony torony) {
    	torony.setHatotavolsag(2.75);
    }

    /**
     * Torony tüzelési gyakoriságának beállítása
     * 
     * @param torony
     */
    public void setVarakozas(Torony torony) {
       torony.setVarakozas(20);
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
