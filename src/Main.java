/**
 * A program fõ osztálya
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
    		new PeldaUseCase()
        });
    }
}
