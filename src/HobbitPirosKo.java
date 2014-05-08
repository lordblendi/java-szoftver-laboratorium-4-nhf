import java.util.Random;

public class HobbitPirosKo extends ToronyKo {
	
	public HobbitPirosKo() {
        objektumAzonosito = "HobbitPirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param hobbit sebzendő ellenség
     */
    @Override
    public void sebez(Hobbit hobbit) {
        hobbit.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
    }


}
