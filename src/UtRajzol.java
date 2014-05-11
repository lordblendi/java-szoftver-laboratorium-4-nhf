import java.awt.Graphics;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UtRajzol extends Kirajzolhato{
	
	/**
	 * Az Ut amelyet kirajzol.
	 */
	private Ut ut;
	
	/**
	 * A kirajzolandó képe.
	 */
	private static BufferedImage kep;
	
	/**
	 * Az Uton lévő ellenségek képei.
	 */
	private ArrayList<EllensegRajzol> ellensegek; 
	
	/**
	 * Az Uton lévő Akadaly képe.
	 */
	private AkadalyRajzol akadaly;
	
	/**
	 * Statikus inicializátor a kirajzolandó képének beolvasásására
	 */
	static {
	    try {
			kep = ImageIO.read(new File("img\\ut.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Konstruktor
     * 
     * @param ut az Ut amelynek a képét kirajzolja
     */
	public UtRajzol(Ut ut){
		this.ut = ut;
		ellensegek = new ArrayList<EllensegRajzol>();
	}
	
	/**
	 * A képének kirajzolása
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 */
	public void kirajzol(Graphics kepernyo){
		kepernyo.drawImage(kep, ut.getPozicio().x, ut.getPozicio().y, null);
		if (akadaly != null){
			akadaly.rarajzol(kepernyo, ut.getPozicio().x, ut.getPozicio().y);
		}
		for (EllensegRajzol ellenseg : ellensegek)
		{
			ellenseg.rarajzol(kepernyo, ut.getPozicio().x, ut.getPozicio().y);
		}
	}
	
	/**
     * Egy Akadaly képének lerakása az Ut képére 
     * 
     * @param akadaly az Akadaly amelynek a kirajzolóját lerakjuk
     */
	public void lerakAkadaly(AkadalyRajzol akadaly){
		this.akadaly= akadaly;
	}
	
	/**
     * Egy AkadalyKo képének lerakása az Ut képére 
     * 
     * @param akadalyKo az AkadalyKo amelynek a kirajzolóját lerakjuk
     */
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo){
		akadaly.lerakAkadalyKo(akadalyKo);
	}
	
	/**
     * Egy Ellenseg képének lerakása az Ut képére 
     * 
     * @param ellenseg az Ellenseg amelynek a kirajzolóját lerakjuk
     */
	public void ralep(EllensegRajzol ellenseg){
		ellensegek.add(ellenseg);
	}
	
	/**
     * Egy Ellenseg képének levétele az Ut képéről 
     * 
     * @param ellenseg az Ellenseg amelynek a kirajzolóját levesszük
     */
	public void lelep(EllensegRajzol ellenseg){
		ellensegek.remove(ellenseg);
	}
}
