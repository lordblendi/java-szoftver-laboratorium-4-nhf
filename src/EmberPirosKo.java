public class EmberPirosKo extends ToronyKo {
    @Override
    public void sebez(Ember ember) {
        KonzolSeged.kiirFuggvenyHivas("legközelebbi", "sebzodik", "2000");
        ember.sebzodik(100);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
