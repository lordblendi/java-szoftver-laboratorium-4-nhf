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
	 * Kép ködben.
	 */
	private static BufferedImage kepKod;
	
	/**
	 * A kirajzolandó torony referenciája
	 */
	private Torony torony;
	
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
	    try {
			kepKod = ImageIO.read(new File("img\\kod.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param torony a kirajzolandó torony referenciája
	 */
	public ToronyRajzol(Torony torony) {
		this.torony = torony;
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param x az kirajzolás helyének x koordinátája
	 * @param y az kirajzolás helyének y koordinátája
	 */
	public void rarajzol(Graphics kepernyo, int x, int y){
		Rajzolo.rajzol(kepernyo, x, y, torony.getKod() ? kepKod : kep);
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