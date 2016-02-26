import java.util.ArrayList;

public class MisionDeSafari implements Mision{
	
	private LugarDeCaza lugarDeCaza;
	
	public Boolean puedeRealizarMision(Demonio unDemonio) {
		ArrayList<Alma> coleccionDeAlmas = lugarDeCaza.getColeccionDeAlmas();
		Integer almasCazadas = 0;
		for (Alma unAlma : coleccionDeAlmas ) {
			if (unDemonio.puedeSerCazada(unAlma)) {
				almasCazadas++;
			}
		}
		return (almasCazadas > (coleccionDeAlmas.size() * 0.1));
	}

}
