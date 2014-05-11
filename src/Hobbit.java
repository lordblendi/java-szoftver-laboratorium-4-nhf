public class Hobbit extends Ellenseg {
	/**
	 * Ennyi hobbit lett létrehozva.
	 */
	private static int objektumDarabszam = 0;
	
    /**
     * Hobbit konstruktora
     * @param jatek kapott játék, amelyben a hobbit részt vesz
     */
    public Hobbit(Jatek jatek) {
        super(jatek);
        objektumDarabszam++;
        objektumAzonosito = "Hobbit" + objektumDarabszam;
    }
    
    /**
     * Kettévágott hobbit létrehozása
     * 
     * @param jatek játék, melyben a hobbit részt vesz.
     * @param ellenseg ennek a mintájára jön létre az új hobbit
     */
    public Hobbit(Jatek jatek, Hobbit ellenseg) {
    	super(jatek, ellenseg);
    	objektumDarabszam++;
        objektumAzonosito = "Hobbit" + objektumDarabszam;
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
     * Hobbit kezdő életerejének beállítása.
     */
    @Override
    public void initElet() {
        elet = 1100;
    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes, boolean kettevagas) {
    	super.sebzodik(sebzes, kettevagas);
    	if (elet <= 0) {
        	jatek.meghalEllenseg(this, 150);
        } else if (kettevagas) {
        	Hobbit uj = new Hobbit(jatek, this);
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
    	return elet / 1100.0;
    }
}
