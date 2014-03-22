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
    	KonzolSeged.kiirFuggvenyVisszateres();
    	return 0;
    }

    /**
     * A kapott akadálykő lerakása az akadályra
     * @param sargaKo
     */
    public void lerakAkadalyKo(SargaKo sargaKo) {
        String valasz = KonzolSeged.beolvas("Van az akadalyon SargaKo?","[in]");
        if("n".equals(valasz)){
            KonzolSeged.kiirMegjegyzes("SargaKo rakerult az akadalyra.");
            this.sargaKo = sargaKo;
        }
        KonzolSeged.kiirFuggvenyVisszateres();
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
                KonzolSeged.kiirFuggvenyHivas("e", "setSebesseg", "sebesseg: int");
                ellenseg.setSebesseg(0.9);
            }
            else{
                KonzolSeged.kiirFuggvenyHivas("s", "ralep", "e");
                sargaKo.ralep(ellenseg);
            }
            KonzolSeged.kiirFuggvenyVisszateres();
        }

    }

}
