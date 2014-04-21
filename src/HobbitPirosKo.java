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
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
            hobbit.sebzodik(350, true);
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
            hobbit.sebzodik(350, false);
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), hobbit.getObjektumAzonosito());
            hobbit.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
        }
    }


}
