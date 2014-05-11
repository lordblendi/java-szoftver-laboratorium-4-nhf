import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SargaKoRajzol {
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\sargako.png"));
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
		kepernyo.drawImage(kep, x, y, null);
	}
}
