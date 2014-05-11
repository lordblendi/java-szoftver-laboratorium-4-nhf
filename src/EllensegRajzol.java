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
	 * Konstruktor
	 * 
	 * @param ellenseg a kirajzolandó ellenség referenciája
	 */
	public EllensegRajzol(Ellenseg ellenseg) {
		this.ellenseg = ellenseg;
	}
	
	/**
	 * A képének kirajzolása, itt csak a heterogén kollekció miatt van megvalósítva.
	 * 
	 * @param kepernyo a palya képe amelyre kirajzolja magát
	 * @param x a kirajzolás helyének x koordinátája
	 * @param y a kirajzolás helyének y koordinátája
	 */
	public void rarajzol(Graphics kepernyo, int x, int y){
		
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
