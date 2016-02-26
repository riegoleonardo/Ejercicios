
public class DemonioDeSombra extends Demonio{
	private static Integer NivelMinimoDeValor = 50;
	
	public Boolean puedeSerCazada (Alma unAlma) {
		return ((unAlma.getNivelDeValor() < NivelMinimoDeValor) && super.puedeSerCazada(unAlma)); 
	}
	
	public void atormentarAlma(Alma unAlma) {
		super.atormentarAlma(unAlma);
		unAlma.reducirValor(Math.round(unAlma.getNivelDeValor()/2));
	}
	
	
}
