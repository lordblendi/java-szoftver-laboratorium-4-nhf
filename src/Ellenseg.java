public abstract class Ellenseg {
	/**
	 * Ellenség életereje.
	 */
    protected int elet;
    
    /**
     * Cellán belüli helyzet.
     */
    protected double helyzet;
    
    /**
     * Játék.
     */
    protected Jatek jatek;
    
    /**
     * Az ellenség erre megy tovább.
     */
    protected Ut kovetkezoPozicio;
    
    /**
     * Ellenség jelenlegi pozíciója.
     */
    protected Ut pozicio;
    
    /**
     * Ellenség sebessége.
     */
    protected double sebesseg;
    
    /**
     * Ellenség azonosítója.
     */
    protected String objektumAzonosito;

    /**
     * Ellenség konstruktora
     *
     * @param jatek játék, melyben az ellenség részt vesz.
     */
    public Ellenseg(Jatek jatek) {
        this.jatek = jatek;
        this.sebesseg = 1;
    }
    
    /**
     * Kettévágott ellenség létrehozása
     * 
     * @param jatek játék, melyben az ellenség részt vesz.
     * @param ellenseg ennek a mintájára jön létre az új ellenség
     */
    public Ellenseg(Jatek jatek, Ellenseg ellenseg) {
    	this(jatek);
    	elet = ellenseg.elet;
    }

    /**
     * Toronykő segítségével sebzi az ellenséget.
     * @param toronyKo
     */
    public abstract void acceptToronyKoSebez(ToronyKo toronyKo);

    /**
     * aktuális pozíció visszaadása
     * @return aktuális pozíció
     */
    public Ut getPozicio() {
        return pozicio;
    }

    /**
     * Beállítja az új pozíciót,
     * valamint az új következő pozíciót.
     *
     * @param pozicio kovetkezo pozicio
     */
    public void setPozicio(Ut pozicio) {
    	System.out.format("%s ralepett az (%d, %d) cellara%n", objektumAzonosito, pozicio.pozicio.x, pozicio.pozicio.y);
        kovetkezoPozicio = pozicio.getKovetkezoLepes();
        this.pozicio = pozicio;
        pozicio.ralep(this);
    }
    
    /**
     * Ellenség kezdő életerejének beállítása.
     */
    public abstract void initElet();

    /**
     * Ellenség sebességének a beállítása a kapott értékre
     *
     * @param sebesseg beállítandó sebesség
     */
    public void setSebesseg(double sebesseg) {
        this.sebesseg = 1 / sebesseg;
    }

    /**
     * Ellenség léptetése.
     * Ha a pozíciói >1, akkor lelép a jelenlegi pozícióról.
     * Beállítja az új pozíciónak a következő pozíciót.
     * Rálép az új pozícióra.
     */
    public void leptet() {
        helyzet += sebesseg;
        
        // kerekítési hiba miatt 10 ~ 9.999
    	if (helyzet >= 9.999) {
    		helyzet = 0;
    		pozicio.lelep(this);
    		setPozicio(kovetkezoPozicio);
    	}
    }

    /**
     * Ellenség sebzése.
     * 
     * @param sebzes ennyivel sebződik az ellenség
     */
    public void sebzodik(int sebzes, boolean kettevagas) {
    	elet -= sebzes;
    }

    /**
     * Visszaadja az objektum azonosítóját.
     * 
     * @return objektum azonosítója
     */
    public String getObjektumAzonosito() {
    	return objektumAzonosito;
    }
}

