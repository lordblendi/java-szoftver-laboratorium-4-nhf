import java.util.Random;

public class EmberPirosKo extends ToronyKo {
    
	public EmberPirosKo() {
        objektumAzonosito = "EmberPirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param ember sebzendő ellenség
     */
    @Override
    public void sebez(Ember ember) {
        ember.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
    }

}
