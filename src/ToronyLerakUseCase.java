/**
 * Torony lerakásához készült usecase
 * Created by Lipták Levente on 2014.03.22.
 */
public class ToronyLerakUseCase implements UseCase{

	@Override
	public String getNev() {
		return "Torony lerakasa use-case";
	}

	@Override
	public void start() {
		KonzolSeged.kiirFuggvenyHivas("ToronyLerakUseCase", "start");
	
		Jatek jatek = new Jatek();
		Torony torony = new Torony(jatek);
        Domborzat d = new Domborzat();
        
        KonzolSeged.kiirFuggvenyHivas("jatek", "lerakTorony","d: Domborzat, torony: Torony");
        jatek.lerakTorony(d, torony);
       
        KonzolSeged.kiirFuggvenyVisszateres();
	}
}
