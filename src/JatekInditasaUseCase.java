/**
 * Játék indítása use-case
 * 
 * @author Varga
 *
 */
public class JatekInditasaUseCase implements UseCase {
	@Override
	public String getNev() {
		return "Jatek inditasa use-case";
	}
	
	@Override
	public void start() {
		Jatek jatek = new Jatek();
		KonzolSeged.kiirFuggvenyHivas("jatek", "indit");
		jatek.indit();
	}
}
