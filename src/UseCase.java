/**
 * Use-case interfész
 * 
 * @author sebokmarton
 */
public interface UseCase {
	/**
	 * Név lekérése
	 * 
	 * @return Név
	 */
	String getNev();
	
	/**
	 * Futtatás 
	 */
	void start();
}
