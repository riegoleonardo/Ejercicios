
public class DemonioDeFuego extends Demonio {
	
	public Boolean puedeSerCazada(Alma unAlma) {
		return ((!unAlma.esFriolenta()) && (super.puedeSerCazada(unAlma)));
	}
	
	public void atormentarAlma (Alma unAlma) {
		super.atormentarAlma(unAlma);
		unAlma.setEsFriolenta(false);
	}
	
	
}
