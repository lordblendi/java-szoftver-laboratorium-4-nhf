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
        System.out.format("jatek letrehozta %s-et%n", objektumAzonosito);
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
    		System.out.format("%s meghalt%n", objektumAzonosito);
        	jatek.meghalEllenseg(this, 150);
        } else if (kettevagas) {
        	System.out.format("%s kettevagva%n", objektumAzonosito);
        	Hobbit uj = new Hobbit(jatek, this);
        	uj.setPozicio(pozicio);
        	jatek.addEllenseg(uj);
        }
    }
}
