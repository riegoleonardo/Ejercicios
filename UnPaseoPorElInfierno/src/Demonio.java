import java.util.ArrayList;

public abstract class  Demonio implements ResidenciaDeAlma {
	protected Integer nivelDeMaldad;
	protected ArrayList<Alma> almasCazadas = new ArrayList<Alma>();
	protected Integer cantidadAlmasAtormentadas;
	protected Integer cantidadAlmasCazadas;
	protected EstadoDeAnimo estadoDeAnimo;
	
	protected Demonio () {
		nivelDeMaldad = 0;
		cantidadAlmasAtormentadas = 0;
		cantidadAlmasCazadas = 0;
		
	}
	
	public void serCastigado() {
		nivelDeMaldad = (int) (nivelDeMaldad * 0.1);
	}
	
	public Demonio(Integer unNivel, EstadoDeAnimo unEstado) {
		nivelDeMaldad = unNivel;
		estadoDeAnimo = unEstado;
		cantidadAlmasAtormentadas = 0;
		cantidadAlmasCazadas = 0;
	}
	
	public Integer getCantidadAlmasCazadas() {
		return cantidadAlmasCazadas;
	}
	
	public void cazarAlma(Alma unAlma) {
		if (this.puedeSerCazada(unAlma)) {
			unAlma.definirResidencia(this);
			this.aumentarMaldad();
			cantidadAlmasCazadas++;
		} else {
			this.atormentarAlma(unAlma);
		}
	};
	
	protected void aumentarMaldad() {
			nivelDeMaldad = cantidadAlmasAtormentadas + almasCazadas.size() * 2;
	}

	public void atormentarAlma(Alma unAlma) {
		unAlma.reducirBondad(5);	
		cantidadAlmasAtormentadas++;
	}
	
	public Boolean puedeSerCazada(Alma unAlma) {
		return (nivelDeMaldad > unAlma.getNivelDeBondad());
	};
	
	public void agregarAlma(Alma unAlma) {
		almasCazadas.add(unAlma);	
	}

	public void quitarAlma(Alma unAlma) {
		almasCazadas.remove(unAlma);
		
	}
	
	public Boolean noTieneAlmas(){
		return (almasCazadas.isEmpty());
	}
	
	public void setNivelDeMaldad (Integer maldad) {
		nivelDeMaldad = maldad;
	}
	
	public Integer getNivelDeMaldad () {
		return nivelDeMaldad;
	}
	
	public ArrayList<Alma> getAlmasCazadas(){
		return almasCazadas;
	}

	public void borrarAlmas() {
		almasCazadas = null;	
	}
}
