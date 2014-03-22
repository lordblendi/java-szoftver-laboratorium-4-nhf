/**
 * Created by Szepes Nóra on 2014.03.22..
 */
public class ToronyTuzeleseUseCase implements UseCase {
    @Override
    public String getNev() {
        return "Torony tuzelese use-case";
    }

    @Override
    public void start() {
        KonzolSeged.kiirKonstruktor("torony");
        KonzolSeged.kiirKonstruktor("jatek");
        KonzolSeged.kiirKonstruktor("ember");
        KonzolSeged.kiirKonstruktor("ut");
        KonzolSeged.kiirKonstruktor("domborzat");
        KonzolSeged.kiirKonstruktor("pont");

        Jatek jatek = new Jatek();

        Torony torony = new Torony(jatek);
        KonzolSeged.kiirFuggvenyHivas("torony", "tuzel");
        torony.tuzel();
    }
}
