import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ut extends Cella {
    Akadaly akadaly = null;
    List<Ellenseg> ellensegek;
    List<Ut> kovetkezoLepesek;

    /**
     * Út konstruktora
     */
    public Ut() {
        super();
        ellensegek = new ArrayList<Ellenseg>();
    }

    /**
     * Sárgakő elhelyezése az úton
     *
     * @param sargaKo elhelyezendő sárgakő
     * @return sikeres-e
     */
    @Override
    public boolean lerakAkadalyKo(SargaKo sargaKo) {
    	if (akadaly != null){
    		akadaly.lerakAkadalyKo(sargaKo);
    		return true;
    	}
    	return false;
    }

    /**
     * Sárgakő elhelyezése a cellán
     *
     * @param sargaKo elhelyezendő sárgakő
     * @return sikeres-e
     */
     @Override
    public boolean lerakAkadaly(Akadaly akadaly) {
    	 if (this.akadaly == null){
    		 this.akadaly=akadaly;
    		 for (Ellenseg ellenseg : ellensegek)
    		 {
    			 this.akadaly.ralep(ellenseg);
    		 }
    		 return true;
    	 }
    	 return false;
    }

    /**
     * Ellenség rálép az útra.
     * Ha van rajta akadály akkor az lelassítja,
     * különben az ellenség áthalad rajta lassítás nélkül.
     *
     * @param ellenseg aki rálép az útra
     */
    public void ralep(Ellenseg ellenseg) {
    	if (akadaly != null){
    		akadaly.ralep(ellenseg);
    	}
    	else{
    		for (Ellenseg e:ellensegek)
    		{
    			e.setSebesseg(1);
    		}
    	}
    }
    
    /**
     * Ellenség lelép az útról.
     * Kikerül az ellenségek kollekcióból.
     * @param ellenseg
     */

    public void lelep(Ellenseg ellenseg) {
        ellensegek.remove(ellenseg);
    }

    /**
     * Visszaadja a következő cellát,
     * amelyre rá tud lépni az ellenség
     * * @return
     */
    public Ut getKovetkezoLepes() {
    	Random rand = new Random(System.currentTimeMillis());
    	return kovetkezoLepesek.get(rand.nextInt(kovetkezoLepesek.size()));
    }
    
    /**
     * Beállítja azokt az utakat,
     * amerre majd az ellenség tovább megy.
     * @param ut következő út
     */
    public void setKovetkezoLepesek(List<Ut> utak) {
    	kovetkezoLepesek = utak;
    }
}
