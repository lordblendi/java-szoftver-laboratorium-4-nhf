import java.awt.Graphics;

public class EllensegRajzol{
	private UtRajzol pozicio;
	
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
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
	public void ralep(UtRajzol pozicio){
		this.pozicio = pozicio;
		pozicio.ralep(this);
	
	}
	public void lelep(){
		pozicio.lelep(this);
		this.pozicio = null;
	}
}
