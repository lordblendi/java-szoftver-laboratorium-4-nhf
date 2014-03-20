public abstract class Cella {
    Pont pozicio;


    protected Cella() {

    }

    public void setPozicio(Pont pozicio) {
        this.pozicio = pozicio;
    }

    public Pont getPozicio() {
        return pozicio;
    }

    public double getTavolsag(Cella cella) {
    	return 0;
    }

    public void lerakAkadaly(Akadaly akadaly) {

    }

    public void lerakAkadalyKo(SargaKo sargaKo) {

    }

    public void lerakTorony(Torony torony) {

    }

    public void lerakToronyKo(ToronyKo toronyKo) {

    }
}
