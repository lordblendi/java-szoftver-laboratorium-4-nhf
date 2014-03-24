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
        KonzolSeged.start(new UseCase[] {
        		new ToronyTuzeleseUseCase(),
                new SargaKoLerakUseCase(),
                new ToronyLerakUseCase(),
                new AkadalyLerakUseCase(),
                new JatekInditasaUseCase(),
                new ZoldKoLerakasaDomborzatraUseCase(),
                new JatekLepteteseUseCase(),
                new HobbitRalepVegzetHegyereUseCase()
        });
    }
}
