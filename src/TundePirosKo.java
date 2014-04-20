import java.util.Random;

public class TundePirosKo extends ToronyKo {

    public TundePirosKo() {
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param tunde sebzendő ellenség
     */
    @Override
    public void sebez(Tunde tunde) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            tunde.sebzodik(350, true);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), tunde.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            tunde.sebzodik(350, false);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), tunde.getClass().getName());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            tunde.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", this.getClass().getName(), tunde.getClass().getName());
        }
    }

}
