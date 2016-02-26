import java.util.ArrayList;
import java.util.Collection;

public abstract class Contenido {
	protected String genero;
	protected Collection<String> actores = new ArrayList<String>();
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public Boolean actua(String unActor){
		return actores.contains(unActor);
	};
	
	public abstract Double getDuracion();
	
	
}
