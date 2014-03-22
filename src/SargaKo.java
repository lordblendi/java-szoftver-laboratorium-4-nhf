public class SargaKo {

    public SargaKo() {
        KonzolSeged.kiirKonstruktor("SargaKo");
    }

    public int getAr() {
        KonzolSeged.kiirFuggvenyHivas("SargaKo", "getAr");
        KonzolSeged.kiirFuggvenyVisszateres("1000");
        return 1000;
    }

    public void ralep(Ellenseg ellenseg) {
        KonzolSeged.kiirFuggvenyHivas("SargaKo", "ralep", "ellenseg: Ellenseg");
        ellenseg.setSebesseg(0.5);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
