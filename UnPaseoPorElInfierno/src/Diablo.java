import java.util.ArrayList;

public class Diablo {
	
	private ArrayList<Alma> almasCosechadas = new ArrayList<Alma>();
	private ArrayList<Demonio> coleccionDeDemonios = new ArrayList<Demonio>();
	
	public void rendirCuentas (Demonio unDemonio) {
		if (unDemonio.noTieneAlmas()) {
			unDemonio.serCastigado();
		} else {
			almasCosechadas.addAll(unDemonio.getAlmasCazadas());
			unDemonio.borrarAlmas();
		}
	}
	
	public void agregarDemonio (Demonio unDemonio) {
		coleccionDeDemonios.add(unDemonio);
	}
	
	public Demonio getPequenioDemonio() {
		Integer minimo  = 0;
		Demonio pequenioDemonio = null;
		for (Demonio unDemonio : coleccionDeDemonios) {
			if ( minimo > unDemonio.getCantidadAlmasCazadas()) {
				pequenioDemonio = unDemonio;
			}
		}
		return pequenioDemonio;
	}
	
	
}
