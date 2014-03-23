public class ZoldKo extends ToronyKo {

    public ZoldKo() {
    }

    @Override
    public void setVarakozas(Torony torony) {
    	KonzolSeged.kiirFuggvenyHivas("torony", "setVarakozas", "varakozas");
    	torony.setVarakozas(100);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
    
    @Override
    public int getAr() {
    	KonzolSeged.kiirFuggvenyVisszateres("ar");
    	return 500;
    }
}
