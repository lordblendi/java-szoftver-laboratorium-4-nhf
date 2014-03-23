/**
 * Hobbit léptetése use-case
 * 
 * @author Varga
 *
 */
public class HobbitLepteteseUseCase implements UseCase {
	@Override
	public String getNev() {
		return "Hobbit leptetese use-case";
	}
	
	@Override
	public void start() {
		Jatek jatek = new Jatek();
		Hobbit hobbit = new Hobbit(jatek);
		Ut pozicio = new Ut();
		Ut kovetkezoPozicio = new Ut();		
		Akadaly akadaly = new Akadaly();		
		SargaKo sargaKo = new SargaKo();		
		
		jatek.ellensegek = new java.util.ArrayList<Ellenseg>();
		jatek.ellensegek.add(hobbit);		
		hobbit.pozicio = pozicio;
		hobbit.kovetkezoPozicio = kovetkezoPozicio;		
		pozicio.kovetkezoLepes = kovetkezoPozicio;		
		kovetkezoPozicio.akadaly = akadaly;		
		akadaly.sargaKo = sargaKo;

        KonzolSeged.kiirFuggvenyHivas("jatek", "leptet");
		jatek.leptet(10);
	}
}
