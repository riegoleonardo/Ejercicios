package packageDefaultClassPOO;

public class Pasajero implements Strategy {

	private double indiceDeBonificacion;
	private double comision;

	public void setIndiceDeBonificacion(double unIndice) {
		indiceDeBonificacion = unIndice;
	}
	
	private Pasajero(){
		
	}
	
	public Pasajero (double unIndice, double unaComision) {
		indiceDeBonificacion = unIndice;
		comision = unaComision;
	}
	public double getIndiceDeBonificacion() {
		return indiceDeBonificacion;
	}

	public void setComision(double unaComision) {
		comision = unaComision;
	}

	public double getComision() {
		return comision;
	}

	public double calcularPrecio(double precio) {
		return ((precio * indiceDeBonificacion) + comision);
	}
}
