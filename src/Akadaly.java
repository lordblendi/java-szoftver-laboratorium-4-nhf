public class Akadaly {
    SargaKo sargaKo;

    public Akadaly() {
        KonzolSeged.kiirKonstruktor("Akadaly");
    }

    public int getAr() {
        return 0;
    }

    public void lerakAkadalyKo(SargaKo sargaKo) {

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
        if(KonzolSeged.getAktualisUseCase().equals("SargaKo lerakasa use-case")){
            if(sargaKo == null){
                KonzolSeged.kiirMegjegyzes("Az akadalyon nincs sargaKo.");
                KonzolSeged.kiirFuggvenyHivas("ellenseg", "setSebesseg", "0.9");
                ellenseg.setSebesseg(0.9);
            }
            else{
                KonzolSeged.kiirFuggvenyHivas("sargaKo", "ralep", "ellenseg");
                sargaKo.ralep(ellenseg);
            }
            KonzolSeged.kiirFuggvenyVisszateres();
        }

    }

}
