public class Akadaly {
    SargaKo sargaKo;
    
    /**
     * Konstruktor
     */
    public Akadaly() {
        
    }
    
    /**
     * Visszaadja az árat
     * @return ára
     */
    public int getAr() {
    	KonzolSeged.kiirFuggvenyVisszateres("ar: int");
    	return 0;
    }

    /**
     * A kapott akadálykő lerakása az akadályra
     * @param sargaKo
     */
    public boolean lerakAkadalyKo(SargaKo sargaKo) {
        String valasz = KonzolSeged.beolvas("Van az akadalyon SargaKo?","[in]");
        if("n".equals(valasz)){
            this.sargaKo = sargaKo;
            KonzolSeged.kiirFuggvenyVisszateres("true");
            return true;
        }
        KonzolSeged.kiirFuggvenyVisszateres("false");
        return false;
    }
    
    /**
     * Ellenség rálép az akadályra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
    	if(KonzolSeged.getAktualisUseCase().equals("Akadaly lerakasa use-case")){
   		 KonzolSeged.kiirFuggvenyHivas("ember", "setSebesseg", "sebesseg: int");
            ellenseg.setSebesseg(0.9);
    	}
        if(KonzolSeged.getAktualisUseCase().equals("SargaKo lerakasa use-case")){
            if(sargaKo == null){
            	KonzolSeged.kiirFuggvenyHivas("e", "setSebesseg", "0.7");
                ellenseg.setSebesseg(0.9);
            }
            else{
            	KonzolSeged.kiirFuggvenyHivas("s", "ralep", "e");
                sargaKo.ralep(ellenseg);
            }
        }
        if (KonzolSeged.getAktualisUseCase().equals("Hobbit leptetese use-case")) {
        	if (sargaKo != null) {
        		KonzolSeged.kiirFuggvenyHivas("sargaKo", "ralep", "hobbit");
        		sargaKo.ralep(ellenseg);
        	} else {
        		KonzolSeged.kiirFuggvenyHivas("hobbit", "setSebesseg", "sebesseg");
        		ellenseg.setSebesseg(0.6);
        	}
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
