import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DomborzatRajzol extends Kirajzolhato{
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * A Domborzaton lévő Torony képe.
	 */
	private ToronyRajzol torony;
	
	/**
	 * A Domborzat amelyet kirajzol.
	 */
	private Domborzat domborzat;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\domborzat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 */
	public DomborzatRajzol (Domborzat domborzat){
		this.domborzat = domborzat;
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 */
	public void kirajzol(Graphics kepernyo){
		kepernyo.drawImage(kep, domborzat.getPozicio().x, domborzat.getPozicio().y, null);
		if (torony != null)
			torony.rarajzol(kepernyo, domborzat.getPozicio().x, domborzat.getPozicio().y);
	}
	
	/**
     * Egy torony képének lerakása a Domborzat képére 
     * 
     * @param torony a torony amelynek képét lerakjuk
     */
	public void lerakTorony(ToronyRajzol torony){
		this.torony = torony;
	}
	
	/**
     * Egy toronykő kirajzolójának lerakása a Domborzat képére 
     * 
     * @param toronyko a kirajzolo amelyet lerakunk
     */
	public void lerakToronyKo(ToronyKoRajzol toronyKo){
		torony.lerakToronyKo(toronyKo);
	}
}
