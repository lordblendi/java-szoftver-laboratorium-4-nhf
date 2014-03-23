public class Hobbit extends Ellenseg {

    /**
     * Hobbit konstruktora
     * @param jatek kapott játék, amelyben a hobbit részt vesz
     */
    public Hobbit(Jatek jatek) {
        super(jatek);
    }

    /**
     * Toronykő segítségével sebzi az ellenséget
     * @param toronyKo
     */
    @Override
    public void acceptToronyKoSebez(ToronyKo toronyKo) {
        super.acceptToronyKoSebez(toronyKo);
    }

    @Override
    public void initElet() {
        super.initElet();
    }

    /**
     * Kapott értékkel sebződik.
     * @param sebzes
     */
    @Override
    public void sebzodik(int sebzes) {
        super.sebzodik(sebzes);
    }
    
    @Override
    public void leptet() {
    	
    	String valasz = KonzolSeged.beolvas("helyzet >= 1.0?", "[in]");
    	if (valasz.equals("i")) {
    		KonzolSeged.kiirFuggvenyHivas("pozicio", "lelep", "hobbit");
    		pozicio.lelep(this);
    		KonzolSeged.kiirFuggvenyHivas("hobbit", "setPozicio", "kovetkezoPozicio");
    		setPozicio(kovetkezoPozicio);
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    @Override
    public void setPozicio(Ut pozicio) {
    	this.pozicio = pozicio;
    	KonzolSeged.kiirFuggvenyHivas("kovetkezoPozicio", "getKovetkezoLepes");
    	kovetkezoPozicio = pozicio.getKovetkezoLepes();
    	KonzolSeged.kiirFuggvenyHivas("kovetkezoPozicio", "ralep", "hobbit");
    	pozicio.ralep(this);
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }
}
