import java.util.Scanner;

/**
 * A program fő osztálya
 *
 * @author sebokmarton
 */
public class Main {
    /**
     * Program indulása, bemenet kezelése
     *
     * @param args Parancssori argumentumok
     */
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	// játék inicializálása
    	Jatek jatek = new Jatek();
    	int x, y;
    	
    	// a bemeneti nyelv utasításainak feldolgozása
    	boolean quit = false;
    	while (!quit && in.hasNext()) {
    		String s = in.nextLine();
    		String[] t = s.split(" ");
    		
    		switch (t[0]) {
    			// torony lerakása
    			case "addTorony":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakTorony(jatek.cellak[x - 1][y - 1], new Torony(jatek));
    				break;
    			// zöld kő lerakása
    			case "addZoldKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new ZoldKo());
    				break;
    			// kék kő lerakása
    			case "addKekKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new KekKo());
    				break;
    			// törp piros kő lerakása
    			case "addTorpPirosKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new TorpPirosKo());
    				break;
    			// hobbit piros kő lerakása
    			case "addHobbitPirosKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new HobbitPirosKo());
    				break;
    			// tünde piros kő lerakása
    			case "addTundePirosKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new TundePirosKo());
    				break;
    			// ember prios kő lerakása
    			case "addEmberPirosKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new EmberPirosKo());
    				break;
    			// akadály lerakása
    			case "addAkadaly":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakAkadaly(jatek.cellak[x - 1][y - 1], new Akadaly());
    				break;
    			// sárga kő lerakása
    			case "addSargaKo":
    				x = Integer.parseInt(t[1]);
    				y = Integer.parseInt(t[2]);
    				jatek.lerakAkadalyKo(jatek.cellak[x - 1][y - 1], new SargaKo());
    				break;
    			// játék léptetése
    			case "tick":
    				int ido = Integer.parseInt(t[1]);
    				jatek.leptet(ido);
    				break;
    			// játék indítása
    			case "indit":
    				jatek.indit(t[1]);
    				break;
    			// véletlenszerű elemek állítása
    			case "random":
    				switch (t[1]) {
    					case "kettevagas":
							if (t[2] == "on")
								Jatek.randomKettevagas = Jatek.Random.ON;
							else if (t[2] == "off")
								Jatek.randomKettevagas = Jatek.Random.OFF;
							else
								Jatek.randomKettevagas = Jatek.Random.AUTO;
    						break;
    					case "utvalasztas":
    						if (t[2] == "on")
								Jatek.randomUtvalasztas = Jatek.Random.ON;
							else if (t[2] == "off")
								Jatek.randomUtvalasztas = Jatek.Random.OFF;
							else
								Jatek.randomUtvalasztas = Jatek.Random.AUTO;
    						break;
    				}
    				System.out.format("%s veletlenszerusegenek atallitasa.\n", t[1]);
    				break;
    			// kilépés
    			case "quit":
    				quit = true;
    				break;
    		}
    	}
    	
    	in.close();
    }
}
