import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Seg�doszt�ly a konzol kezel�s�hez
 * 
 * @author sebokmarton
 */
public class KonzolSeged {
	/**
	 * Beh�z�s m�rt�ke 
	 */
	private static int behuzas = 0;
	
	/**
	 * H�v�sokat t�rol� verem
	 */
	private static Stack<String> hivasok = new Stack<String>();
	
	/**
	 * Scanner a beolvas�shoz
	 */
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Szkeleton kezel�i fel�let�nek elind�t�sa
	 * 
	 * @param useCasek V�laszthat� use-case-ek list�ja
	 */
	static void start(UseCase[] useCasek) {
		System.out.println("52 - Nagymama lekv�rjai szkeleton");
		
		while (true) {
			System.out.println("V�laszthat� use-casek (vagy kil�p�s):\n");
			
			int i = 1;
			
			for (UseCase useCase: useCasek) {
				System.out.println(i + ". " + useCase.getNev());
				i++;
			}
			System.out.print(i + ". Kil�p�s\n\n");
			
			int c = Integer.parseInt(beolvas("K�rlek, add meg a v�lasztott sorsz�mot", "[1-" + i + "]"));
			
			if (c == i) {
				return;
			} else {
				System.out.println("\n" + c + ". " + useCasek[c - 1].getNev() + " futtat�sa...\n");
				useCasek[c - 1].start();
				System.out.println();
			}
		}
	}
	
	/**
	 * Ki�r�s beh�z�ssal
	 * 
	 * @param x Sz�veg
	 */
	private static void print(String x) {
		for (int i = 0; i < behuzas; i++) {
			System.out.print("    ");
		}
		
		System.out.print(x);
	}
	
	/**
	 * Ki�r�s beh�z�ssal �j sorba
	 * 
	 * @param x Sz�veg
	 */
	private static void println(String x) {
		print(x);
		System.out.println();
	}
	
	
	/**
	 * @see KonzolSeged#kiirFuggvenyHivas(String, String, String)
	 */
	static public void kiirFuggvenyHivas(String objektum, String fuggveny) {
		kiirFuggvenyHivas(fuggveny, objektum, "");
	}
	
	/**
	 * F�ggv�nyh�v�s kezdet�nek ki�r�sa
	 * 
	 * @param objektum H�vott f�ggv�nyhez tartoz� objektum neve
	 * @param fuggveny H�vott f�ggv�ny neve
	 * @param parameterek H�vott f�ggv�ny param�terei t�pusukkal egy�tt, vessz�vel elv�lasztva (Java szintaxis)
	 */
	static public void kiirFuggvenyHivas(String objektum, String fuggveny, String parameterek) {
		String call = objektum + "." + fuggveny;
		
		println(call + " h�v�s (" + parameterek + ")");
		behuzas++;
		hivasok.push(call);
	}
	
	/**
	 * @see KonzolSeged#kiirFuggvenyVisszateres(String)
	 */
	static public void kiirFuggvenyVisszateres() {
		kiirFuggvenyVisszateres("");
	}
	
	/**
	 * F�ggv�nyh�v�s v�g�nek ki�r�sa
	 * 
	 * @param ertekek Visszat�r�si �rt�kek t�pusukkal egy�tt, vessz�vel elv�lasztva (Java szintaxis)
	 */
	static public void kiirFuggvenyVisszateres(String ertekek) {
		String call = hivasok.pop();
		
		behuzas--;
		println(call + " visszat�r�s" + (ertekek.length() > 0 ? " (" + ertekek + ")" : ""));
	}
	
	/**
	 * Megjegyz�s ki�r�sa
	 * 
	 * @param megj Megjegyz�s
	 */
	static public void kiirMegjegyzes(String megj) {
		println(megj);
	}
	
	/**
	 * @see KonzolSeged#kiirKonstruktor(String, String)
	 */
	static public void kiirKonstruktor(String objektum) {
		kiirKonstruktor(objektum, "");
	}
	
	/**
	 * Objektum l�trehoz�s�nak ki�r�sa
	 * 
	 * @param objektum L�trehozand� objektum neve
	 * @param parameterek Konstruktor param�terei t�pusukkal egy�tt, vessz�vel elv�lasztva (Java szintaxis)
	 */
	static public void kiirKonstruktor(String objektum, String parameterek) {
		println(objektum + " l�trehoz�sa (" + parameterek + ")");
	}
	
	/**
	 * Beolvas�s a bemenetr�l
	 * @see java.util.regex.Pattern
	 * 
	 * @param kerdes Felhaszn�l�nak feltett k�rd�s
	 * @param minta V�laszt illeszt� minta (Pattern szintaxis)
	 * @return �rv�nyes felhaszn�l�i v�lasz
	 */
	static public String beolvas(String kerdes, String minta) {
		String r = null;
		
		Pattern p = Pattern.compile(minta);
		print(kerdes + " " + minta + ": ");
		
		do {
			try {
				r = in.next(p);
			} catch (NoSuchElementException e) {
				print("Hib�s v�lasz, k�rlek, adj meg egy helyeset: ");
			} finally {
				in.nextLine();
			}
		} while (r == null);
		
		return r;
	}
}
