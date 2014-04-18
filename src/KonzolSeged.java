import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Segédosztály a konzol kezeléséhez
 *
 * @author sebokmarton
 */
public class KonzolSeged {
    /**
     * Behúzás mértéke
     */
    static private int behuzas = 0;

    /**
     * Hívásokat tároló verem
     */
    static private Stack<String> hivasok = new Stack<String>();

    /**
     * Scanner a beolvasáshoz
     */
    static private Scanner in = new Scanner(System.in);
    
    /**
     * Aktuálisan futó use-case neve
     */
    static private String aktualisUseCase = null;
    
    /**
     * Aktuálisan futó use-case nevének lekérdezése
     * 
     * @return Név
     */
    static public String getAktualisUseCase() {
    	if (1 == 1)
    		return "egyik sem";
    	
    	return aktualisUseCase;
    }

    /**
     * Szkeleton kezelői felületének elindítása
     *
     * @param useCasek Választható use-case-ek listája
     */
    static void start(UseCase[] useCasek) {
		System.out.println("52 - Nagymama lekvarjai szkeleton");

        while (true) {
			System.out.println("Valaszthato use-casek (vagy kilepes):\n");

            int i = 1;

            for (UseCase useCase : useCasek) {
                System.out.println(i + ". " + useCase.getNev());
                i++;
            }
			System.out.print(i + ". Kilepes\n\n");

			int c = Integer.parseInt(beolvas("Kerlek, add meg a valasztott sorszamot", "[1-" + i + "]"));

            if (c == i) {
                return;
            } else {
				System.out.println("\n" + c + ". " + useCasek[c - 1].getNev() + " futtatasa...\n");
				aktualisUseCase = useCasek[c - 1].getNev();
                useCasek[c - 1].start();
                System.out.println();
            }
        }
    }

    /**
     * Kiírás behúzással
     *
     * @param x Szöveg
     */
    static private void print(String x) {
        for (int i = 0; i < behuzas; i++) {
            System.out.print("    ");
        }

        System.out.print(x);
    }

    /**
     * Kiírás behúzással új sorba
     *
     * @param x Szöveg
     */
    static private void println(String x) {
        print(x);
        System.out.println();
    }


    /**
     * @see KonzolSeged#kiirFuggvenyHivas(String, String, String)
     */
    static public void kiirFuggvenyHivas(String objektum, String fuggveny) {
    	if (1 == 1)
    		return;
    	
		kiirFuggvenyHivas(objektum, fuggveny, "");
    }

    /**
     * Függvényhívás kezdetének kiírása
     *
     * @param objektum    Hívott függvényhez tartozó objektum neve
     * @param fuggveny    Hívott függvény neve
     * @param parameterek Hívott függvény paraméterei típusukkal együtt, vesszővel elválasztva (Java szintaxis)
     */
    static public void kiirFuggvenyHivas(String objektum, String fuggveny, String parameterek) {
    	if (1 == 1)
    		return;
    	
        String call = objektum + "." + fuggveny;

		println(call + " hivas (" + parameterek + ")");
        behuzas++;
        hivasok.push(call);
    }

    /**
     * @see KonzolSeged#kiirFuggvenyVisszateres(String)
     */
    static public void kiirFuggvenyVisszateres() {
    	if (1 == 1)
    		return;
    	
        kiirFuggvenyVisszateres("");
    }

    /**
     * Függvényhívás végének kiírása
     *
	 * @param ertekek Visszatérési értékek típusukkal együtt, vesszővel elválasztva (Java szintaxis)
     */
    static public void kiirFuggvenyVisszateres(String ertekek) {
    	if (1 == 1)
    		return;
    	
        String call = hivasok.pop();

        behuzas--;
		println(call + " visszateres" + (ertekek.length() > 0 ? " (" + ertekek + ")" : ""));
    }

    /**
     * Megjegyzés kiírása
     *
     * @param megj Megjegyzés
     */
    static public void kiirMegjegyzes(String megj) {
    	if (1 == 1)
    		return;
    	
        println(megj);
    }

    /**
     * @see KonzolSeged#kiirKonstruktor(String, String)
     */
    static public void kiirKonstruktor(String objektum) {
    	if (1 == 1)
    		return;
    	
        kiirKonstruktor(objektum, "");
    }

    /**
     * Objektum létrehozásának kiírása
     *
     * @param objektum    Létrehozandó objektum neve
     * @param parameterek Konstruktor paraméterei típusukkal együtt, vesszővel elválasztva (Java szintaxis)
     */
    static public void kiirKonstruktor(String objektum, String parameterek) {
    	if (1 == 1)
    		return;
    	
		println(objektum + " letrehozasa (" + parameterek + ")");
    }

    /**
     * Választási lehetőség kiírása, válasz beolvasása
	 * @see java.util.regex.Pattern
     *
     * @param kerdes Felhasználónak feltett kérdés
     * @param minta  Választ illesztő minta (Pattern szintaxis)
     * @return Érvényes felhasználói válasz
     */
    static public String beolvas(String kerdes, String minta) {
    	if (1 == 1)
    		return null;
    	
        String r = null;

        Pattern p = Pattern.compile(minta);
        print(kerdes + " " + minta + ": ");

        do {
            try {
                r = in.next(p);
            } catch (NoSuchElementException e) {
				print("Hibas valasz, kerlek, adj meg egy helyeset: ");
            } finally {
                in.nextLine();
            }
        } while (r == null);

        return r;
    }
}
