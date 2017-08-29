import java.awt.Color;
import java.awt.Graphics;

public class EllensegRajzol{
	/**
	 * A cella képe amelyen az ellenség áll
	 */
	private Kirajzolhato pozicio;
	
	/**
	 * A kirajzolandó ellenség referenciája
	 */
	protected Ellenseg ellenseg;
	
	/**
	 * Az ellenség színe
	 */
	protected Color szin;
	
	/**
	 * Konstruktor
	 * 
	 * @param ellenseg a kirajzolandó ellenség referenciája
	 */
	public EllensegRajzol(Ellenseg ellenseg, Color szin) {
		this.ellenseg = ellenseg;
		this.szin = szin;
	}
	
	/**
	 * A képének kirajzolása, itt csak a heterogén kollekció miatt van megvalósítva.
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param i a kirajzolás helyének x koordinátája
	 * @param y a kirajzolás helyének y koordinátája
	 * @param i hányadik ellenség a cellán?
	 */
	public void rarajzol(Graphics kepernyo, int i, int j, int k){
		int x = (j - 1) * Rajzolo.CELLAMERET + 6;
		int y = (i - 1) * Rajzolo.CELLAMERET + 8 + k * 12;
		
		kepernyo.setColor(Color.LIGHT_GRAY);
		kepernyo.drawRect(x, y, 48, 8);
		kepernyo.setColor(Color.WHITE);
		kepernyo.fillRect(x + 1, y + 1, 47, 7);
		kepernyo.setColor(szin);
		kepernyo.fillRect(x + 1, y + 1, (int)Math.ceil(47 * ellenseg.getElet()), 7);
	}
	
	/**
	 * Az ellenség képének rátétele egy cella kirajzolójára
	 * 
	 * @param pozicio a Cella képe, amelyre ráléptetjük az Ellenseget
	 */
	public void ralep(Kirajzolhato pozicio){
		this.pozicio = pozicio;
		pozicio.ralep(this);
	}
	
	/**
	 * Az ellenség képének levétele a cella kirajzolójáról amelyen áll
	 */
	public void lelep(){
		pozicio.lelep(this);
		this.pozicio = null;
	}
}
