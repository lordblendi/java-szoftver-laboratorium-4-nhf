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
        Jatek jatek = new Jatek();
        SargaKo sargaKo = new SargaKo();
        Akadaly akadaly = new Akadaly();
        Ut ut = new Ut();
        ut.akadaly = akadaly;
        Ellenseg ember = new Ember(jatek);

        KonzolSeged.kiirFuggvenyHivas("sargaKo", "getAr");
        sargaKo.getAr();

        KonzolSeged.kiirFuggvenyHivas("jatek", "lerakAkadalyKo", "ut, sargaKo");
        jatek.lerakAkadalyKo(ut,sargaKo);

        KonzolSeged.kiirMegjegyzes("Jelenleg egy Ember faju ellenseg tartozkodik ezen az uton.");
        KonzolSeged.kiirFuggvenyHivas("ut", "ralep", "ember");
        ut.ralep(ember);

    }
}
