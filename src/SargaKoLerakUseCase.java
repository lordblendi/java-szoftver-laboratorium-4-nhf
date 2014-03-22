/**
 * Created by Nóra on 2014.03.22..
 */
public class SargaKoLerakUseCase implements  UseCase {
    @Override
    public String getNev() {
        return "SárgaKő lerakása use-case";
    }

    @Override
    public void start() {
        KonzolSeged.kiirFuggvenyHivas("SargaKoLerakUseCase", "start");
        SargaKo sargaKo = new SargaKo();
        sargaKo.getAr();
        String valasz = KonzolSeged.beolvas("Van eleg varazsero?","[in]");
        if("i".equals(valasz)){

        }
        else if("n".equals(valasz)){
           KonzolSeged.kiirMegjegyzes("Nincs eleg varazsero a SargaKo vasarlashoz.");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
