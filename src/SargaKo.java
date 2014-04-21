public class SargaKo {
	private static int  objektumDarabszam;
	private String objektumAzonosito;
	
	/**
     *  Sárgakő konstruktora
     */
    public SargaKo() {
    	objektumAzonosito = "SargaKo" + ++objektumDarabszam;
    }

    /**
     * A kapott ellenség rálép egy sárgakővel felszerelt útra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
    	ellenseg.setSebesseg(2.1);
    	System.out.format("%s lelassitotta %s-et 2.1-re%n", objektumAzonosito, ellenseg.getObjektumAzonosito());
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
    
    /**
     * Objektum törlése, ha nem sikerült lerakni.
     */
    public void dispose() {
    	objektumDarabszam--;
    }
}
