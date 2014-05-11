import java.awt.Graphics;

public class TundeRajzol extends EllensegRajzol {
	/**
	 * Konstruktor
	 * 
	 * @param ellenseg a kirajzolandó ellenség referenciája
	 */
	public TundeRajzol(Ellenseg ellenseg) {
		super(ellenseg);
	}
	
	/**
	 * A képének kirajzolása, itt csak a heterogén kollekció miatt van megvalósítva
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param x a kirajzolás helyének x koordinátája
	 * @param y a kirajzolás helyének y koordinátája
	 */
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
}
