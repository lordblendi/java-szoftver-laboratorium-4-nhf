import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class VegzetHegyeRajzol extends Kirajzolhato{
	private static BufferedImage kep;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\vegzethegye.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Pont pozicio;
	
	private VegzetHegye vegzetHegye;
	
	public VegzetHegyeRajzol(VegzetHegye v){
		vegzetHegye = v;
	}
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
}
