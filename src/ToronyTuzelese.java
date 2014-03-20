public class ToronyTuzelese implements UseCase {

	@Override
	public String getNev() {
		return "Torony t�zel�se egy emberre";
	}

	@Override
	public void start() {
		KonzolSeged.kiirFuggvenyHivas("obj", "fv", "a: int, b: String");
		KonzolSeged.kiirFuggvenyHivas("obj2", "fv2");
		KonzolSeged.kiirMegjegyzes("megj");
		String s = KonzolSeged.beolvas("igen vagy nem?", "[in]");
		KonzolSeged.kiirFuggvenyVisszateres();
		KonzolSeged.kiirKonstruktor("obj3", "c: double");
		KonzolSeged.kiirFuggvenyVisszateres("d: char");
	}

}
