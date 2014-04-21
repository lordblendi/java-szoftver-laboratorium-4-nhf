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
        if(Jatek.randomKettevagas == Jatek.Random.ON){
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
            torp.sebzodik(350, true);
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.OFF){
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
            torp.sebzodik(350, false);
        }
        else  if(Jatek.randomKettevagas == Jatek.Random.AUTO){
            System.out.format("%s megsebezte %s-et 350 sebzessel%n", getObjektumAzonosito(), torp.getObjektumAzonosito());
            torp.sebzodik(350, ((((new Random()).nextInt(100))%7) == 0));
        }
    }

}
