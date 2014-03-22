import java.util.Collection;

public class Jatek {
    Collection<Cella> cellak;
    Collection<Ellenseg> ellensegek;
    Collection<Ut> kezdoPoziciok;
    int maradekEllenseg;
    Collection<Torony> tornyok;
    int varazsero;

    /**
     * Játék konstruktora
     */
    public Jatek() {
        KonzolSeged.kiirKonstruktor("Jatek");
    }

    public Collection<Ellenseg> getEllensegek() {
        return ellensegek;
    }

    public void indit(){

    }

    public void leptet(int ido) {

    }
    /**
     * Kapott akadály elhelyezése a kapott cellán, ha van elég varázserőnk.
     * @param cella ezen a cellán akarjuk elhelyezni az akadályt
     * @param akadaly ezt az akadályt akarjuk elhelyezni
     */
    public void lerakAkadaly(Cella cella, Akadaly akadaly) {
    	KonzolSeged.kiirFuggvenyHivas("akadaly", "getAr");
    	akadaly.getAr();
    	String s = KonzolSeged.beolvas("van elegendo varazsero az akadaly letetelehez?", "[in]");
    	if (s.equals("i")){
    	KonzolSeged.kiirFuggvenyHivas("ut", "lerakAkadaly", "akadaly: Akadaly");	
    	cella.lerakAkadaly(akadaly);
    	}
    	else if (s.equals("n")){
    	akadaly = null;	    
    	}
    	else{
    	KonzolSeged.kiirMegjegyzes("hibas valasz");
    	}
    	
    	KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Kapott akadálykő elhelyezése a kapott cellán
     * @param cella ezen a cellán akarjuk elhelyezni a sárgakövet
     * @param sargaKo ezt a sárgakövet akarjuk rátenni a cellára
     */
    public void lerakAkadalyKo(Cella cella, SargaKo sargaKo) {
        KonzolSeged.kiirFuggvenyHivas("Jatek", "larakAkadalyKo", "cella: Cella, sargaKo: SargaKo");
        cella.lerakAkadalyKo(sargaKo);
        KonzolSeged.kiirFuggvenyVisszateres();
    }

    /**
     * Kapott torony elhelyezése a kapott cellán, ha van elég varázserőnk.
     * @param cella ezen a cellán akarjuk elhelyezni a tornyot
     * @param torony ezt a tornyot akarjuk elhelyezni
     */
    public void lerakTorony(Cella cella, Torony torony) {
    	KonzolSeged.kiirFuggvenyHivas("Torony", "getAr");
    	torony.getAr();
    	
    	String s = KonzolSeged.beolvas("van elegendo varazsero a torony letetelehez?", "[in]");
    	if (s.equals("i")){
    	KonzolSeged.kiirFuggvenyHivas("d", "lerakTorony", "torony: Torony");	
    	cella.lerakTorony(torony);
    	}
    	else if (s.equals("n")){
    	torony = null;	    
    	}
    	else{
    	KonzolSeged.kiirMegjegyzes("hibas valasz");
    	}
    	KonzolSeged.kiirFuggvenyVisszateres();
    }

    public void lerakToronyKo(Cella cella, ToronyKo toronyKo) {

    }

    public void meghalEllenseg(Ellenseg ellenseg, int jutalom) {

    }

    /**
     * Ha a Játéknak vége, akkor meghívódik ez a függvény.
     * @param nyertunk egy bool, mely alapján el lehet dönteni, ki nyerte a játékot.
     */
    public void vege(boolean nyertunk) {
        KonzolSeged.kiirFuggvenyHivas("Jatek", "vege", "nyertunk: boolean");
        if(nyertunk){
            KonzolSeged.kiirMegjegyzes("A jateknak vege. A jatekos nyert.");
        }
        else{
            KonzolSeged.kiirMegjegyzes("A jateknak vege. A jatekos vesztett.");
        }
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
