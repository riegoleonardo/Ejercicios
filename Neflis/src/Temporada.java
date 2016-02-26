import java.util.ArrayList;


public class Temporada {
	
	private ArrayList<Capitulo> capitulosDeLaTemporada = new ArrayList<Capitulo>();
	private Serie serieDeLaTemporada;
	
	public Boolean fueVistaPor(Usuario unUsuario) {
		int i = 0;
		Boolean fueVista = true;
		while (fueVista && i < capitulosDeLaTemporada.size()) {
			fueVista = unUsuario.vioContenido(capitulosDeLaTemporada.get(i));
			i++;
		}
		return fueVista;
	}
	
	public Boolean actua(String unActor) {
		return (serieDeLaTemporada.actua(unActor));
	}

	public Double getDuracion() {
		Double duracionTotal = 0.0;
		for(Capitulo unCapitulo : capitulosDeLaTemporada) {
			duracionTotal+=unCapitulo.getDuracion();
		}
		return duracionTotal;
	}

	public String  getGenero() {
		return serieDeLaTemporada.getGenero();
		
	}
}
