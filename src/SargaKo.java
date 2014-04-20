public class SargaKo {
	private static int  objektumDarabszam;
	private String objektumAzonosito;
	
	/**
     *  Sárgakő konstruktora
     */
    public SargaKo() {
    }

    /**
     * A kapott ellenség rálép egy sárgakővel felszerelt útra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
    	ellenseg.setSebesseg(2.1);
    }
    
    /**
     * Sárgakő árának visszaadása
     * @return a sárgakő ára
     */
    public int getAr() {
        KonzolSeged.kiirFuggvenyVisszateres("1000");
        return 100;
    }
    
    public String getObjektumAzonosito(){
    	return objektumAzonosito;
    }
}
