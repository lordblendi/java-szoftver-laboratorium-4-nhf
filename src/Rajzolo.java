import javax.swing.JFrame;

import java.util.*;

public class Rajzolo extends JFrame{
	HashMap<Cella, Kirajzolhato> palya;
	
	HashMap<Ellenseg, EllensegRajzol> ellensegek;
	
	public Rajzolo(HashMap<Cella,Kirajzolhato> palya){
	 this.palya = palya;
	}
	
	public void Rajzol(int varazsEro){
		//kirajzolja a palya osszes ckirajzolhatojat+ kiirja a varazserot
	}
	public void lerakAkadaly(AkadalyRajzol akadaly, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakAkadaly(akadaly);
	}
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakAkadalyKo(akadalyKo);
	}
	public void lerakTorony(ToronyRajzol torony, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakTorony(torony);
	}
	public void lerakToronyKo(ToronyKoRajzol toronyKo, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakToronyKo(toronyKo);
	}
	public void vege(boolean nyertunk){
		//felugró ablak..
	}
	public void addEllenseg(Ut ut, Ellenseg ellenseg, EllensegRajzol ellensegRajzol){
		ellensegek.put(ellenseg, ellensegRajzol);
		((EllensegRajzol) ellensegek.get(ellenseg)).ralep(((UtRajzol) palya.get(ellenseg)));
	}
	public void atlep(Ut ut, Ellenseg ellenseg){
		((EllensegRajzol) ellensegek.get(ellenseg)).lelep();
		((EllensegRajzol) ellensegek.get(ellenseg)).ralep(((UtRajzol) palya.get(ellenseg)));
	}
	public void meghalEllenseg(Ellenseg ellenseg){
		((EllensegRajzol) ellensegek.get(ellenseg)).lelep();
		ellensegek.remove(ellenseg);
	}
}
