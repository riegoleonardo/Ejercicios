import java.util.ArrayList;

public class LugarDeCaza implements ResidenciaDeAlma {
	
	private ArrayList<Alma> coleccionDeAlmas = new ArrayList<Alma>(); 
	
	public void agregarAlma(Alma unAlma) {
		coleccionDeAlmas.add(unAlma);	
	}

	public void quitarAlma(Alma unAlma) {
		coleccionDeAlmas.remove(unAlma);
		
	}
	
	public ArrayList<Alma> getColeccionDeAlmas() {
		return coleccionDeAlmas;
	}
	
	public void enviarACazarAlDemonio (Demonio unDemonio) {
		for (Alma unAlma : coleccionDeAlmas) {
			unDemonio.cazarAlma(unAlma);
		}
	}
}
