import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ToronyRajzol {
	private static BufferedImage kep;
	
	private ToronyKoRajzol ko;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\torony.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		kepernyo.drawImage(kep, x, y, null);
		ko.rarajzol(kepernyo, x, y);
	}
	public void lerakToronyKo(ToronyKoRajzol toronyKo){
		ko = toronyKo;
	}
}