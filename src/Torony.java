public class Torony {
    int hatotavolsag;
    Jatek jatek;
    Domborzat pozicio;
    ToronyKo toronyKo;
    int varakozas;

    public Torony(Jatek jatek) {
        this.jatek = jatek;
    }
    
    /**
     * Torony árának lekérdezése
     */
    public int getAr() {
    	KonzolSeged.kiirFuggvenyVisszateres();
    	return 0;
    }
    
    /**
     * Toronykő lerakása a toronyra.
     * 
     * @param toronyKo ezt rakja rá a toronyra
     */
    public void lerakToronyKo(ToronyKo toronyKo) {
    	String valasz = KonzolSeged.beolvas("A torony meg ko nelkuli?", "[in]");
    	if (valasz.equals("i")) {
    		KonzolSeged.kiirFuggvenyHivas("zold", "setVarakozas", "torony");
    		toronyKo.setVarakozas(this);
    		KonzolSeged.kiirFuggvenyHivas("zold", "setHatotavolsag", "torony");
    		toronyKo.setHatotavolsag(this);
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * A torony sebzi a kapott ellenséget
     * @param ellenseg
     */
    public void sebez(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("legkozelebbi", "sebzodik", "1000");
        ellenseg.sebzodik(10);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    /**
     * Torony pozíciójának beállítása
     * 
     * @param domborzat a torony ezen a Domborzaton lesz
     */
    public void setPozicio(Domborzat domborzat) {
        this.pozicio = domborzat;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Torony hatótávolságának beállítása
     * 
     * @param hatotavolsag torony hatótávolsága
     */
    public void setHatotavolsag(int hatotavolsag) {
        this.hatotavolsag = hatotavolsag;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Torony tüzelési gyakoriságának beállítása.
     * 
     * @param varakozas tüzelési gyakoriság
     */
    public void setVarakozas(int varakozas) {
        this.varakozas = varakozas;
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * A torony tüzel az összes ellenségre.
     * Megnézi, hogy az ellenség hatótávolságon belül van-e.
     * Ha azon belül van, akkor ha van rajta toronykő,
     * akkor annak segítségével sebzi,
     * különben a saját sebez függvényét hívja meg.
     */    
    public void tuzel() {
    	String jelenlegiUseCase = KonzolSeged.getAktualisUseCase();
    	
    	if (jelenlegiUseCase.equals("Jatek leptetese use-case")) {
    		KonzolSeged.kiirFuggvenyVisszateres();
    		return;
    	}
    	
        String valasz = KonzolSeged.beolvas("varakozas == 0?", "[in]");
        if("i".equals(valasz)){
            ToronyKo toronyKo = new EmberPirosKo();
            Ut ut = new Ut();
            Jatek jatek = new Jatek();
            Domborzat domborzat = new Domborzat();
            Ellenseg ember = new Ember(jatek);
            ember.pozicio = ut;

            KonzolSeged.kiirFuggvenyHivas("jatek", "getEllensegek");
            jatek.getEllensegek();

            KonzolSeged.kiirFuggvenyHivas("ember", "getPozicio");
            ember.getPozicio();

            KonzolSeged.kiirFuggvenyHivas("ut", "getTavolsag", "domborzat");
            double d = ut.getTavolsag(domborzat);

            valasz = KonzolSeged.beolvas("hatotavolsag <= 2.0?", "[in]");

            if ("i".equals(valasz)) {
                valasz = KonzolSeged.beolvas("toronyKo == null?", "[in]");
                if("i".equals(valasz)){
                    KonzolSeged.kiirFuggvenyHivas("torony", "sebez", "legkozelebbi");
                    sebez(ember);
                }
                else{
                    KonzolSeged.kiirFuggvenyHivas("legkozelebbi", "acceptToronyKoSebez", "toronyKo");
                    ember.acceptToronyKoSebez(toronyKo);
                }

            }
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
