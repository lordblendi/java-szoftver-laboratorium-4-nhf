public abstract class ToronyKo {

    /**
     * Konstruktor
     */
    public ToronyKo() {
    }
    
    /**
     * Toronykő árának lekérdezése
     */
    public int getAr() {
        return 0;
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param ember sebzendő ellenség
     */
    public void sebez(Ember ember) {
        KonzolSeged.kiirFuggvenyHivas("legközelebbi", "sebzodik", "sebzes");
        ember.sebzodik(100);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param hobbit sebzendő ellenség
     */
    public void sebez(Hobbit hobbit) {

    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param torp sebzendő ellenség
     */
    public void sebez(Torp torp) {

    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param tunde sebzendő ellenség
     */
    public void sebez(Tunde tunde) {

    }

    /**
     * Torony hatótávolságának beállítása
     * 
     * @param torony
     */
    public void setHatotavolsag(Torony torony) {
    	KonzolSeged.kiirFuggvenyHivas("torony", "setHatotavolsag", "hatotavolsag");
    	torony.setHatotavolsag(5);
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }

    
    /**
     * Torony tüzelési gyakoriságának beállítása
     * 
     * @param torony
     */
    public void setVarakozas(Torony torony) {

    }
}
