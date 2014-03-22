public class Akadaly {
    SargaKo sargaKo;

    public Akadaly() {
        KonzolSeged.kiirKonstruktor("Akadaly");
    }

    public int getAr() {
    	KonzolSeged.kiirFuggvenyVisszateres();
    	return 0;
    }

    public void lerakAkadalyKo(SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("Akadaly", "lerakAkadalyKo", "sargaKo: SargaKo");
        String valasz = KonzolSeged.beolvas("Van az akadalyon SargaKo?","[in]");
        if("n".equals(valasz)){
            KonzolSeged.kiirMegjegyzes("SargaKo rakerult az akadalyra.");
            this.sargaKo = sargaKo;
        }
        else if("i".equals(valasz)){
            KonzolSeged.kiirMegjegyzes("SargaKovet csak olyan akadalyra lehet rakni, amin meg nincs SargaKo.");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("Akadaly", "ralep", "ellenseg: Ellenseg");
        if(sargaKo == null){
            KonzolSeged.kiirMegjegyzes("Az akadalyon nincs sargaKo.");
        }
        else{
            sargaKo.ralep(ellenseg);
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }

}
