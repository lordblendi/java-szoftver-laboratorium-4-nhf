import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class DomborzatRajzol extends Kirajzolhato{
	private BufferedImage kep;
	
	private ToronyRajzol torony;
	
	private Pont pozicio;
	
	private Domborzat domborzat;
	
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
