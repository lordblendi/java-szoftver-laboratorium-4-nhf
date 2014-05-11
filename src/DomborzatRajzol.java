import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DomborzatRajzol extends Kirajzolhato{
	private static BufferedImage kep;
	
	private ToronyRajzol torony;
	
	private Pont pozicio;
	
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
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
	
	public void lerakTorony(ToronyRajzol torony){
		this.torony = torony;
	}
	
	public void lerakToronyKo(ToronyKoRajzol toronyKo){
		torony.lerakToronyKo(toronyKo);
	}
}
