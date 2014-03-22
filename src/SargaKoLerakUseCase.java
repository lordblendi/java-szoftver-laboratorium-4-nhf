/**
 * Sárgakő lerakásához készült usecase
 * Created by Szepes Nóra on 2014.03.22.
 */
public class SargaKoLerakUseCase implements UseCase {
    @Override
    public String getNev() {
        return "SargaKo lerakasa use-case";
    }

    @Override
    public void start() {
        KonzolSeged.kiirFuggvenyHivas("SargaKoLerakUseCase", "start");
        Jatek jatek = new Jatek();
        SargaKo sargaKo = new SargaKo();
        Akadaly akadaly = new Akadaly();
        Ut ut = new Ut();
        ut.akadaly = akadaly;
        Ember ember = new Ember(jatek);
        sargaKo.getAr();

        jatek.lerakAkadalyKo(ut,sargaKo);
        KonzolSeged.kiirMegjegyzes("Jelenleg egy Ember faju ellenseg tartozkodik ezen az uton.");
        ut.ralep(ember);
//        String valasz = KonzolSeged.beolvas("Van eleg varazsero?", "[in]");
//        if ("i".equals(valasz)) {
//            valasz = KonzolSeged.beolvas("A SargaKovet utra raknad?", "[in]");
//            if ("i".equals(valasz)) {
//                jatek.lerakAkadalyKo(ut,sargaKo);
////                ut.lerakAkadalyKo(sargaKo);
//                KonzolSeged.kiirMegjegyzes("Jelenleg egy Ember faju ellenseg tartozkodik ezen az uton.");
//                ut.ralep(ember);
//            } else if ("n".equals(valasz)) {
//                KonzolSeged.kiirMegjegyzes("SargaKovet csak utra lehet elhelyezni.");
//            }
//        } else if ("n".equals(valasz)) {
//            KonzolSeged.kiirMegjegyzes("Nincs eleg varazsero a SargaKo vasarlashoz.");
//        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
