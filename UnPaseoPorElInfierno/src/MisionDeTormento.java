import java.util.ArrayList;

public class MisionDeTormento implements Mision {

	private ArrayList<LugarDeCaza> coleccionDeLugares = new ArrayList<LugarDeCaza>();
	
	public Boolean puedeRealizarMision(Demonio unDemonio) {
		for (LugarDeCaza unLugar : coleccionDeLugares ) {
			ArrayList<Alma> coleccionDeAlmas = unLugar.getColeccionDeAlmas();
			Boolean atormentoUnAlma = false;
			for(Alma unAlma : coleccionDeAlmas) {
				atormentoUnAlma = (unAlma.getNivelDeBondad() < 15);
			}
			if (!atormentoUnAlma) {
				return false;
			}
		}
		return true;
	}

}
