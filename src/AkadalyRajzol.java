import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class AkadalyRajzol {
	
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * Az Akadalyon lévő kő képe.
	 */
	private SargaKoRajzol ko;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\akadaly.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param x a kirajzolás helyének x koordinátája
	 * @param y a kirajzolás helyének y koordinátája
	 */
	public void rarajzol(Graphics kepernyo, int x, int y){
		Rajzolo.rajzol(kepernyo, x, y, kep);
		if (ko != null){
			ko.rarajzol(kepernyo, x, y);
		}
	}
	
	/**
     * Egy AkadalyKo képének lerakása az Ut képére 
     * 
     * @param akadalyKo az AkadalyKo amelynek a kirajzolóját lerakjuk
     */
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo){
		ko = akadalyKo;
	}
}
