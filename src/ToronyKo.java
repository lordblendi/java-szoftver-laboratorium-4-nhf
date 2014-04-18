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
        return 100;
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param ember sebzendő ellenség
     */
    public void sebez(Ember ember) {
        ember.sebzodik(250);
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param hobbit sebzendő ellenség
     */
    public void sebez(Hobbit hobbit) {
        hobbit.sebzodik(250);
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param torp sebzendő ellenség
     */
    public void sebez(Torp torp) {
        torp.sebzodik(250);
    }

    /**
     * Sebzi a paraméterként kapott embert
     *
     * @param tunde sebzendő ellenség
     */
    public void sebez(Tunde tunde) {
        tunde.sebzodik(250);
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
       torony.setVarakozas(2.0);
    }
}
