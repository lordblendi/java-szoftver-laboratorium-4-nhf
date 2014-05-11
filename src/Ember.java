public class Ember extends Ellenseg {
	/**
	 * Ennyi ember lett létrehozva.
	 */
	private static int objektumDarabszam = 0;
	
    /**
     * Ember konstruktora
     * @param jatek kapott játék, amelyben az ember részt vesz
     */
    public Ember(Jatek jatek) {
        super(jatek);
        objektumDarabszam++;
        objektumAzonosito = "Ember" + objektumDarabszam;
    }
    
    /**
     * Kettévágott ember létrehozása
     * 
     * @param jatek játék, melyben az ember részt vesz.
     * @param ellenseg ennek a mintájára jön létre az új ember
     */
    public Ember(Jatek jatek, Ember ellenseg) {
    	super(jatek, ellenseg);
    	objektumDarabszam++;
        objektumAzonosito = "Ember" + objektumDarabszam;
    }

    /**
     * Toronykő segítségével sebzi az ellenséget
     * @param toronyKo
     */
    @Override
    public void acceptToronyKoSebez(ToronyKo toronyKo) {
        toronyKo.sebez(this);
    }

    /**
     * Ember kezdő életerejének beállítása.
     */
    @Override
    public void initElet() {
    	elet = 1000;
    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes, boolean kettevagas) {
        super.sebzodik(sebzes, kettevagas);
        if (elet <= 0) {
        	jatek.meghalEllenseg(this, 100);
        } else if (kettevagas) {
        	Ember uj = new Ember(jatek, this);
        	uj.setPozicio(pozicio);
        	jatek.kettevagva(uj);
        }
    }
    
    /**
     * Visszaadja az az ellenség életpontjainak százalékos értékét
     * 
     * @return az ellenseg életpontjai
     */
    @Override
    public double getElet() {
    	return elet / 1000.0;
    }
}
