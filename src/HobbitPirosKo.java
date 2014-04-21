import java.util.Random;

public class HobbitPirosKo extends ToronyKo {

    private static int objektumDarabszam = 0;
    private String objektumAzonosito;

    public HobbitPirosKo() {
        objektumAzonosito = "HobbitPirosKo" + ++objektumDarabszam;
    }

    /**
     * Megsebezzük a kapott ellenséget 350-el.
     * @param hobbit sebzendő ellenség
     */
    @Override
    public void sebez(Hobbit hobbit) {
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            hobbit.sebzodik(350, true);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            hobbit.sebzodik(350, false);
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            hobbit.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
            System.out.format("%s megsebezte %s-et 350 sebzessel.%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
        }
    }


}
