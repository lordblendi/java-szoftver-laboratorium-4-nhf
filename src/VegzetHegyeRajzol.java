import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class VegzetHegyeRajzol extends Kirajzolhato{
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * A VégzetHegyen lévő ellenségek képei.
	 */
	private ArrayList<EllensegRajzol> ellensegek; 
	
	/**
	 * A VegzetHegye amelyet kirajzol.
	 */
	private VegzetHegye vegzetHegye;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\vegzethegye.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Konstruktor
     * 
     * @param v a VegzetHegye amelynek a képét kirajzolja
     */
	public VegzetHegyeRajzol(VegzetHegye v){
		vegzetHegye = v;
		ellensegek = new ArrayList<EllensegRajzol>();
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 */
	public void kirajzol(Graphics kepernyo, int x, int y){
		kepernyo.drawImage(kep, vegzetHegye.getPozicio().x, vegzetHegye.getPozicio().y, null);
		for (EllensegRajzol ellenseg : ellensegek)
		{
			ellenseg.rarajzol(kepernyo, vegzetHegye.getPozicio().x, vegzetHegye.getPozicio().y);
		}
	}
	
	/**
     * Egy Ellenseg képének lerakása a VégzetHegye képére 
     * 
     * @param ellenseg az Ellenseg amelynek a kirajzolóját lerakjuk
     */
	public void ralep(EllensegRajzol ellenseg){
		ellensegek.add(ellenseg);
	}
}
