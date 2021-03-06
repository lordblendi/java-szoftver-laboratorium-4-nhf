public class Tunde extends Ellenseg {
	/**
	 * Ennyi tünde lett létrehozva.
	 */
	private static int objektumDarabszam = 0;
	
    /**
     * Tünde konstruktora.
     * @param jatek ebben a játékban szerepel a tünde.
     */
    public Tunde(Jatek jatek) {
        super(jatek);
        objektumDarabszam++;
        objektumAzonosito = "Tunde" + objektumDarabszam;
    }
    
    /**
     * Kettévágott tünde létrehozása
     * 
     * @param jatek játék, melyben a tünde részt vesz.
     * @param ellenseg ennek a mintájára jön létre az új tünde
     */
    public Tunde(Jatek jatek, Tunde ellenseg) {
    	super(jatek, ellenseg);
    	objektumDarabszam++;
        objektumAzonosito = "Tunde" + objektumDarabszam;
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
     * Tünde kezdő életerejének beállítása.
     */
    @Override
    public void initElet() {
        elet = 1300;
    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes, boolean kettevagas) {
    	super.sebzodik(sebzes, kettevagas);
    	if (elet <= 0) {
        	jatek.meghalEllenseg(this, 250);
        } else if (kettevagas) {
        	Tunde uj = new Tunde(jatek, this);
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
    	return elet / 1300.0;
    }
}
