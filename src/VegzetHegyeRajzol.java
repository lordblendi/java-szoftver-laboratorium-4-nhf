import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class VegzetHegyeRajzol extends Kirajzolhato{
	private static BufferedImage kep;
	
	private ArrayList<EllensegRajzol> ellensegek; 
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\vegzethegye.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private VegzetHegye vegzetHegye;
	
	public VegzetHegyeRajzol(VegzetHegye v){
		vegzetHegye = v;
		ellensegek = new ArrayList<EllensegRajzol>();
	}
	
	public void kirajzol(Graphics kepernyo, int x, int y){
		kepernyo.drawImage(kep, vegzetHegye.getPozicio().x, vegzetHegye.getPozicio().y, null);
		for (EllensegRajzol ellenseg : ellensegek)
		{
			ellenseg.rarajzol(kepernyo, vegzetHegye.getPozicio().x, vegzetHegye.getPozicio().y);
		}
	}
	public void ralep(EllensegRajzol ellenseg){
		ellensegek.add(ellenseg);
	}
}
