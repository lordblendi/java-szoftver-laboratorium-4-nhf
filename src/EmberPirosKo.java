import java.util.Random;

public class EmberPirosKo extends ToronyKo {

    private static int objektumDarabszam = 0;
    private String objektumAzonosito;

    public EmberPirosKo() {
        objektumAzonosito = "EmberPirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param ember sebzendő ellenség
     */
    @Override
    public void sebez(Ember ember) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            ember.sebzodik(350, true);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            ember.sebzodik(350, false);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            ember.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), ember.getObjektumAzonosito());
        }
    }

}
