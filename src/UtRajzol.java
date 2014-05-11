import java.awt.Graphics;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UtRajzol extends Kirajzolhato{
	private Ut ut;
	
	private static BufferedImage kep;
	
	private ArrayList<EllensegRajzol> ellensegek; 
	
	private AkadalyRajzol akadaly;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\ut.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UtRajzol(Ut ut){
		this.ut = ut;
	}
	
	public void kirajzol(Graphics kepernyo){
		
	}
	
	public void lerakAkadaly(AkadalyRajzol akadaly){
		akadaly= akadaly;
	}
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo){
		akadaly.lerakAkadalyKo(akadalyKo);
	}
	public void ralep(EllensegRajzol ellenseg){
		ellensegek.add(ellenseg);
	}
	public void lelep(EllensegRajzol ellenseg){
		ellensegek.remove(ellenseg);
	}
}
