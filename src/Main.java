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

            if (t[0].equals("addTorony")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakTorony(jatek.cellak[x - 1][y - 1], new Torony(jatek));

                // zöld kő lerakása
            } else if (t[0].equals("addZoldKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new ZoldKo());

                // kék kő lerakása
            } else if (t[0].equals("addKekKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new KekKo());

                // törp piros kő lerakása
            } else if (t[0].equals("addTorpPirosKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new TorpPirosKo());

                // hobbit piros kő lerakása
            } else if (t[0].equals("addHobbitPirosKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new HobbitPirosKo());

                // tünde piros kő lerakása
            } else if (t[0].equals("addTundePirosKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new TundePirosKo());

                // ember prios kő lerakása
            } else if (t[0].equals("addEmberPirosKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakToronyKo(jatek.cellak[x - 1][y - 1], new EmberPirosKo());

                // akadály lerakása
            } else if (t[0].equals("addAkadaly")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakAkadaly(jatek.cellak[x - 1][y - 1], new Akadaly());

                // sárga kő lerakása
            } else if (t[0].equals("addSargaKo")) {
                x = Integer.parseInt(t[1]);
                y = Integer.parseInt(t[2]);
                jatek.lerakAkadalyKo(jatek.cellak[x - 1][y - 1], new SargaKo());

                // játék léptetése
            } else if (t[0].equals("tick")) {
                int ido = Integer.parseInt(t[1]);
                jatek.leptet(ido);

                // játék indítása
            } else if (t[0].equals("indit")) {
                jatek.indit(t[1]);

                // véletlenszerű elemek állítása
            } else if (t[0].equals("random")) {
                if (t[1].equals("kettevagas")) {
                    if (t[2] == "on")
                        Jatek.randomKettevagas = Jatek.Random.ON;
                    else if (t[2] == "off")
                        Jatek.randomKettevagas = Jatek.Random.OFF;
                    else
                        Jatek.randomKettevagas = Jatek.Random.AUTO;

                } else if (t[1].equals("utvalasztas")) {
                    if (t[2] == "on")
                        Jatek.randomUtvalasztas = Jatek.Random.ON;
                    else if (t[2] == "off")
                        Jatek.randomUtvalasztas = Jatek.Random.OFF;
                    else
                        Jatek.randomUtvalasztas = Jatek.Random.AUTO;

                }
                System.out.format("%s veletlenszerusegenek atallitasa.\n", t[1]);

                // kilépés
            } else if (t[0].equals("quit")) {
                quit = true;

            }
    	}
    	
    	in.close();
    }
}
