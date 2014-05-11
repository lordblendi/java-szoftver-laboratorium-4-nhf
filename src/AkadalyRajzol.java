import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class AkadalyRajzol {
	private static BufferedImage kep;
	
	private SargaKoRajzol ko;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\akadaly.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
	
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo){
		
	}
}
