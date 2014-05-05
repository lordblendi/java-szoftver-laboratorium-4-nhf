import java.awt.Graphics;
import java.util.*;

public class UtRajzol extends Kirajzolhato{
	private Ut ut;
	
	private ArrayList<EllensegRajzol> ellensegek; 
	
	private AkadalyRajzol akadaly;
	
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
