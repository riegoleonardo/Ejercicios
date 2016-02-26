import java.util.ArrayList;
import java.util.Collection;

public class Capitulo implements ContenidoVisible{
	private Collection<String> actoresInvitados = new ArrayList<String>();
	private Temporada temporadaDelCapitulo;
	private Double duracion;
	
	public Capitulo (Temporada unaTemporada, Double unaDuracion, Collection<String> unaColeccionDeActores) {
		temporadaDelCapitulo = unaTemporada;
		duracion = unaDuracion;
		actoresInvitados = unaColeccionDeActores;
	}
	
	public Double getDuracion() {
		return duracion;
	}
	
	public Boolean actua(String unActor) {
		return ( actoresInvitados.contains(unActor) || temporadaDelCapitulo.actua(unActor) );
	}
	
	public Temporada getTemporadaDelCapitulo() {
		return temporadaDelCapitulo;
	}
	
	public String getGenero(){
		return temporadaDelCapitulo.getGenero();
	}
	
}
