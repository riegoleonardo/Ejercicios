import java.util.ArrayList;


public class Serie extends Contenido{
	private ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
	
	public Boolean fueVistaPor(Usuario unUsuario) {
		Integer i = 0;
		Boolean serieVista = true;
		while (serieVista && i<temporadas.size()) {
			serieVista = temporadas.get(i).fueVistaPor(unUsuario);
			i++;
		}
		return serieVista;
	}

	@Override
	public Double getDuracion() {
		Double duracionTotal = 0.0;
		for (Temporada unaTemporada : temporadas) {
			duracionTotal+=unaTemporada.getDuracion();
		}
		return duracionTotal;
	}
	

	
}
