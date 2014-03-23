/**
 * Zöld kő lerakása egy domborzatra use-case
 * 
 * @author Varga
 *
 */
public class ZoldKoLerakasaDomborzatraUseCase implements UseCase {
	@Override
	public String getNev() {
		return "ZoldKo lerakasa egy domborzatra use-case";
	}
	
	@Override
	public void start() {
		Jatek jatek = new Jatek();
		Domborzat domb = new Domborzat();
		Torony torony = new Torony(jatek);
		domb.torony = torony;
		ZoldKo zold = new ZoldKo();
		
		KonzolSeged.kiirFuggvenyHivas("jatek", "lerakToronyKo", "domb, zold");
		jatek.lerakToronyKo(domb, zold);
	}
}
