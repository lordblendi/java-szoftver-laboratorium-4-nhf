import java.util.Random;

public class TorpPirosKo extends ToronyKo {
	
	public TorpPirosKo() {
        objektumAzonosito = "TorpPirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param torp sebzendő ellenség
     */
    @Override
    public void sebez(Torp torp) {
        torp.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
    }

}
