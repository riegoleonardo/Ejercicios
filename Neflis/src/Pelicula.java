
public class Pelicula extends Contenido implements ContenidoVisible{
	public Double duracion;
	
	public void setDuracion (Double unaDuracion) {
		duracion = unaDuracion;
	}
	
	public Double getDuracion() {
		return duracion;
	}

	public Boolean vioContenido(Usuario unUsuario) {
		return (unUsuario.vioContenido(this));
	}

	@Override
	public Boolean actua(String unActor) {
		return actores.contains(unActor);
	}
	
	
}
