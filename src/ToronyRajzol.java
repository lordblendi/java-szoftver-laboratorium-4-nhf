import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ToronyRajzol {
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * A Tornyon lévő toronykő képe.
	 */
	private ToronyKoRajzol ko;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\torony.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param x az kirajzolás helyének x koordinátája
	 * @param y az kirajzolás helyének y koordinátája
	 */
	public void rarajzol(Graphics kepernyo, int x, int y){
		kepernyo.drawImage(kep, x, y, null);
		if (ko != null){
			ko.rarajzol(kepernyo, x, y);
		}
	}
	
	/**
     * Egy ToronyKo képének lerakása a Torony képére 
     * 
     * @param toronyKo A kirajzoló amelynek képét letesszük
     */
	public void lerakToronyKo(ToronyKoRajzol toronyKo){
		ko = toronyKo;
	}
}