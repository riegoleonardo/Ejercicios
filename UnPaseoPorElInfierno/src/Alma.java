
public class Alma {
	private Integer nivelDeValor;
	private Integer nivelDeBondad;
	private Boolean esFriolenta;
	private ResidenciaDeAlma residenciaActual;

	
	public void reducirBondad(Integer unTormento) {
		nivelDeBondad-=unTormento;
	}
	
	public Integer getNivelDeBondad() {
		return nivelDeBondad;
	}
	
	public void reducirValor (Integer valor) {
		nivelDeValor-=valor;
	}
	
	public Integer getNivelDeValor() {
		return nivelDeValor;
	}
	
	public Boolean esFriolenta() {
		return esFriolenta;
	}

	public void setEsFriolenta(Boolean elAlmaEsFriolenta) {
		esFriolenta = elAlmaEsFriolenta;
	}
	
	public void definirResidencia(ResidenciaDeAlma unaResidencia) {
		unaResidencia.agregarAlma(this);
		if(residenciaActual != null) {
			residenciaActual.quitarAlma(this);		
		}
		residenciaActual = unaResidencia;
	}
}
