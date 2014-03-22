public class SargaKo {
    /**
     *  Sárgakő konstruktora
     */
    public SargaKo() {
        KonzolSeged.kiirKonstruktor("SargaKo");
    }

    /**
     * Sárgakő árának visszaadása
     * @return a sárgakő ára
     */
    public int getAr() {
        KonzolSeged.kiirFuggvenyHivas("SargaKo", "getAr");
        KonzolSeged.kiirFuggvenyVisszateres("1000");
        return 1000;
    }

    /**
     * A kapott ellenség rálép egy sárgakővel felszerelt útra.
     * @param ellenseg
     */
    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("SargaKo", "ralep", "ellenseg: Ellenseg");
        ellenseg.setSebesseg(0.5);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
