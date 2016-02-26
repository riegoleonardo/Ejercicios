import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;


public class Usuario {
	private Collection<ContenidoVisible> contenidoVisto = new ArrayList<ContenidoVisible>();

	public Boolean vioContenido(ContenidoVisible unContenido) {
		return contenidoVisto.contains(unContenido);
	}
	
	public Boolean esFanDe(String unActor) {
		for (ContenidoVisible unContenido : contenidoVisto) {
			if (!unContenido.actua(unActor)) {
			 	return false;
			}
		}
		return true;
	}
	
	public HashSet<String> getGenerosVistos() {
		HashSet<String> generosVistos = new HashSet<String>();
		for (ContenidoVisible unContenido : contenidoVisto) {
			generosVistos.add(unContenido.getGenero());
		}
		return generosVistos;
	}
	
	public String getGeneroPreferido() {
		HashMap<String, Double> generosYDuracion = new HashMap<String, Double>();
		for(ContenidoVisible unContenido : contenidoVisto) {
			if(generosYDuracion.containsKey(unContenido.getGenero())) {
				Double duracion = generosYDuracion.get(unContenido.getGenero());
				duracion+=unContenido.getDuracion();
				generosYDuracion.put(unContenido.getGenero(), duracion);
			} else {
				generosYDuracion.put(unContenido.getGenero(), unContenido.getDuracion());
			}
		}
		Double duracionMaxima = 0.0;
		String generoPreferido = new String();
		for(java.util.Map.Entry<String, Double> entrada : generosYDuracion.entrySet()) {
			if(duracionMaxima < entrada.getValue()) {
				generoPreferido = entrada.getKey();
			}
		}
		return generoPreferido;
	}
	
	
	
}

