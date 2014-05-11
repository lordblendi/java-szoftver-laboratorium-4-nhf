import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TundePirosKoRajzol implements ToronyKoRajzol {
	private static BufferedImage kep;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\tundepirosko.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		kepernyo.drawImage(kep, x, y, null);
	}
}
