public class ZoldKo extends ToronyKo {

    public ZoldKo() {
    }

    @Override
    public void setVarakozas(Torony torony) {
    	KonzolSeged.kiirFuggvenyHivas("torony", "setVarakozas", "100");
    	torony.setVarakozas(100);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    @Override
    public int getAr() {
    	KonzolSeged.kiirFuggvenyVisszateres("500");
    	return 500;
    }
}
