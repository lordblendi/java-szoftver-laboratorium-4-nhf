public class Akadaly {
    private static int objektumDarabszam = 0;
	private String objektumAzonosito;
    private SargaKo sargaKo = null;
    
    /**
     * Konstruktor
     */
    public Akadaly() {
    	objektumAzonosito = "Akadaly" + objektumDarabszam++;
    }
    
    
    public String getObjektumAzonosito(){
    	return objektumAzonosito;
    }
    /**
     * Visszaadja az árat
     * @return ára
     */
    public int getAr() {

    	return 300;
    }

    /**
     * A kapott akadálykő lerakása az akadályra
     * @param sargaKo
     */
    public boolean lerakAkadalyKo(SargaKo sargaKo) {
    
    	if (this.sargaKo == null){
    		this.sargaKo = sargaKo;
    		return true;
    	}
        return false;
    }
    
    /**
     * Ellenség rálép az akadályra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
    	if (sargaKo == null){
    		ellenseg.setSebesseg(1 / 1.5);
    		System.out.format("%s lelassitotta %s-et 1.5-re%n", objektumAzonosito, ellenseg.getObjektumAzonosito());
    	}
    	else{
    		sargaKo.ralep(ellenseg);
    	}
    }
    
    /**
     * Objektum törlése, ha nem sikerült lerakni.
     */
    public void dispose() {
    	objektumDarabszam--;
    }
}