/**
 * A program f� oszt�lya
 * 
 * @author sebokmarton
 */
public class Main {
	/**
	 * Program indul�sa
	 * 
	 * @param args Parancssori argumentumok
	 */
	public static void main(String[] args) {
        KonzolSeged.start(new UseCase[] {
    		new PeldaUseCase()
        });
    }
}
