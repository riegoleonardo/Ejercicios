
public class DemonioDeHielo extends Demonio {
	
	public Boolean puedeSerCazada(Alma unAlma) {
		return ((unAlma.esFriolenta()) && (super.puedeSerCazada(unAlma)));
	}
	
	public void atormentarAlma (Alma unAlma) {
		super.atormentarAlma(unAlma);
		unAlma.setEsFriolenta(true);
	}
}
