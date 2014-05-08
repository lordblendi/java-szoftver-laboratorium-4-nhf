import java.util.Random;

public class TundePirosKo extends ToronyKo {
	
	public TundePirosKo() {
        objektumAzonosito = "TundePirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Tunde tunde) {
        tunde.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
    }

}
