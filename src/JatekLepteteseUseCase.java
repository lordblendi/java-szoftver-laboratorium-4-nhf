import java.util.ArrayList;

/**
 * Játék léptetése use-case
 * 
 * @author Varga
 *
 */
public class JatekLepteteseUseCase implements UseCase {
	static boolean emberLep;
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
		Ut pozicio = new Ut();
		Ut kovetkezoPozicio = new Ut();		
		Akadaly akadaly = new Akadaly();		
		SargaKo sargaKo = new SargaKo();		
		
		jatek.ellensegek = new java.util.ArrayList<Ellenseg>();
		jatek.ellensegek.add(hobbit);		
		hobbit.pozicio = pozicio;
		hobbit.kovetkezoPozicio = kovetkezoPozicio;		
		pozicio.kovetkezoLepesek = new ArrayList<Ut>();
		pozicio.kovetkezoLepesek.add(kovetkezoPozicio);			
		kovetkezoPozicio.akadaly = akadaly;		
		akadaly.sargaKo = sargaKo;
		
		jatek.kezdoPoziciok = new java.util.ArrayList<Ut>();
		jatek.kezdoPoziciok.add(kezdoPozicio);
		
		jatek.tornyok = new java.util.ArrayList<Torony>();
		jatek.tornyok.add(torony);
		
		KonzolSeged.kiirFuggvenyHivas("jatek", "leptet", "100");
		jatek.leptet(100);
	}
}
