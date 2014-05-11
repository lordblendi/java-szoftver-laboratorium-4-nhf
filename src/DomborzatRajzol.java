import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DomborzatRajzol extends Kirajzolhato{
	private static BufferedImage kep;
	
	private ToronyRajzol torony;
	
	private Domborzat domborzat;
	
	static {
	    try {
			kep = ImageIO.read(new File("img\\domborzat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DomborzatRajzol (Domborzat domborzat){
		this.domborzat = domborzat;
	}
	
	public void kirajzol(Graphics kepernyo){
		kepernyo.drawImage(kep, domborzat.getPozicio().x, domborzat.getPozicio().y, null);
		if (torony != null)
			torony.rarajzol(kepernyo, domborzat.getPozicio().x, domborzat.getPozicio().y);
	}
	
	public void lerakTorony(ToronyRajzol torony){
		this.torony = torony;
	}
	
	public void lerakToronyKo(ToronyKoRajzol toronyKo){
		torony.lerakToronyKo(toronyKo);
	}
}
