import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class EmberPirosKoRajzol implements ToronyKoRajzol {
	private static BufferedImage kep;
	
	static {
		    try {
				kep = ImageIO.read(new File("img\\emberpirosko.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
}
