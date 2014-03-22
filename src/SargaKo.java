public class SargaKo {
    /**
     *  Sárgakő konstruktora
     */
    public SargaKo() {
    }

    /**
     * Sárgakő árának visszaadása
     * @return a sárgakő ára
     */
    public int getAr() {

        KonzolSeged.kiirFuggvenyVisszateres("1000");
        return 1000;
    }

    /**
     * A kapott ellenség rálép egy sárgakővel felszerelt útra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("e", "setSebesseg", "sebesseg");
        ellenseg.setSebesseg(0.5);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
