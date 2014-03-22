public class EmberPirosKo extends ToronyKo {
    @Override
    public void sebez(Ember ember) {
        KonzolSeged.kiirFuggvenyHivas("legközelebbi", "sebzodik", "sebzes");
        ember.sebzodik(100);
        KonzolSeged.kiirFuggvenyVisszateres();
    }
}
