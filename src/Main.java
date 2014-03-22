/**
 * A program fő osztálya
 *
 * @author sebokmarton
 */
public class Main {
    /**
     * Program indulása
     *
     * @param args Parancssori argumentumok
     */
    public static void main(String[] args) {
        KonzolSeged.start(new UseCase[]{
                new SargaKoLerakUseCase(),
                new HobbitRalepVegzetHegyereUseCase(),
                new ToronyTuzeleseUseCase()
        });
    }
}
