import java.awt.Graphics;

public class EllensegRajzol{
	private UtRajzol pozicio;
	
	public void rarajzol(Graphics kepernyo, int x, int y){
		
	}
	public void ralep(UtRajzol pozicio){
		pozicio.ralep(this);
		this.pozicio = pozicio;
	}
	public void lelep(){
		pozicio.lelep(this);
		this.pozicio = null;
	}
}
