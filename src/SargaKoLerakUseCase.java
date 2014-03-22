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
        SargaKo s = new SargaKo();
        Akadaly a = new Akadaly();
        Ut u = new Ut();
        u.akadaly = a;
        Ellenseg e = new Ember(jatek);



        KonzolSeged.kiirFuggvenyHivas("jatek", "lerakAkadalyKo", "ut, s");
        jatek.lerakAkadalyKo(u,s);


    }
}
