/**
 * Created by Szepes Nóra on 2014.03.22.
 */
public class HobbitRalepVegzetHegyereUseCase implements UseCase{
    @Override
    public String getNev() {
        return "Hobbit ralep a Vegzet Hegyere use-case";
    }

    @Override
    public void start() {
        Jatek jatek = new Jatek();
        Hobbit hobbit = new Hobbit(jatek);
        Ut ut = new Ut();
        VegzetHegye vegzetHegye = new VegzetHegye(jatek);
        hobbit.pozicio=ut;
        hobbit.kovetkezoPozicio=vegzetHegye;


        KonzolSeged.kiirFuggvenyHivas("hobbit", "leptet");
        hobbit.leptet();

    }
}
