public class Torp extends Ellenseg {
	/**
	 * Ennyi törp lett létrehozva.
	 */
	private static int objektumDarabszam = 0;
	
    /**
     * Törp konstruktrora
     * @param jatek ebben a játékban szerepel a törp
     */
    public Torp(Jatek jatek) {
        super(jatek);
        objektumDarabszam++;
        objektumAzonosito = "Torp" + objektumDarabszam;
        System.out.format("jatek letrehozta %s-et%n", objektumAzonosito);
    }
    
    /**
     * Kettévágott törp létrehozása
     * 
     * @param jatek játék, melyben a tötp részt vesz.
     * @param ellenseg ennek a mintájára jön létre az új törp
     */
    public Torp(Jatek jatek, Torp ellenseg) {
    	super(jatek, ellenseg);
    	objektumDarabszam++;
        objektumAzonosito = "Torp" + objektumDarabszam;
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
     * Törp kezdő életerejének beállítása.
     */
    @Override
    public void initElet() {
        elet = 1200;
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
        	jatek.meghalEllenseg(this, 200);
        } else if (kettevagas) {
        	System.out.format("%s kettevagva%n", objektumAzonosito);
        	Torp uj = new Torp(jatek, this);
        	uj.setPozicio(pozicio);
        	jatek.addEllenseg(uj);
        }
    }
}
