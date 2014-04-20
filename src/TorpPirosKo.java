import java.util.Random;

public class TorpPirosKo extends ToronyKo {

    public TorpPirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param torp sebzendő ellenség
     */
    @Override
    public void sebez(Torp torp) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            torp.sebzodik(350, true);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), torp.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            torp.sebzodik(350, false);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), torp.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            torp.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), torp.getClass().getName());
        }
    }

}
