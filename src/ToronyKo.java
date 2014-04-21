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
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            ember.sebzodik(250, true);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            ember.sebzodik(250, false);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            ember.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param hobbit sebzendő ellenség
     */
    public void sebez(Hobbit hobbit) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            hobbit.sebzodik(250, true);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            hobbit.sebzodik(250, false);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            hobbit.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param torp sebzendő ellenség
     */
    public void sebez(Torp torp) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            torp.sebzodik(250, true);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            torp.sebzodik(250, false);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            torp.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
        }
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param tunde sebzendő ellenség
     */
    public void sebez(Tunde tunde) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            tunde.sebzodik(250, true);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), tunde.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            tunde.sebzodik(250, false);
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), tunde.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            tunde.sebzodik(250, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 250 sebzessel%n", getObjektumAzonosito(), tunde.getObjektumAzonosito());
        }
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
