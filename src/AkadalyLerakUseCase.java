/**
 * Torony lerakásához készült usecase
 * Created by Lipták Levente on 2014.03.22.
 */
public class AkadalyLerakUseCase  implements UseCase{

	@Override
	public String getNev() {
		return "Akadaly lerakasa use-case";
	}

	@Override
	public void start() {
		Jatek jatek = new Jatek();
		Akadaly akadaly = new Akadaly();
        Ut ut = new Ut();
        Ember ember = new Ember(jatek);
        ut.ellensegek.add(ember);
        
        KonzolSeged.kiirFuggvenyHivas("jatek", "lerakAkadaly","ut: Ut, akadaly: Akadaly");
        jatek.lerakAkadaly(ut, akadaly);
       
        KonzolSeged.kiirFuggvenyVisszateres();
	}
}