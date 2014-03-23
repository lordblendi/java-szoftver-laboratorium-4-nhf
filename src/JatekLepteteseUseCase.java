/**
 * Játék léptetése use-case
 * 
 * @author Varga
 *
 */
public class JatekLepteteseUseCase implements UseCase {
	@Override
	public String getNev() {
		return "Jatek leptetese use-case";
	}
	
	@Override
	public void start() {
		Jatek jatek = new Jatek();
		Ut kezdoPozicio = new Ut();
		Hobbit hobbit = new Hobbit(jatek);
		Torony torony = new Torony(jatek);
		
		jatek.kezdoPoziciok = new java.util.ArrayList<Ut>();
		jatek.kezdoPoziciok.add(kezdoPozicio);
		
		jatek.tornyok = new java.util.ArrayList<Torony>();
		jatek.tornyok.add(torony);
		
		jatek.leptet(100);
	}
}
