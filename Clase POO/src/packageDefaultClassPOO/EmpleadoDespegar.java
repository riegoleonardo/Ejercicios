package packageDefaultClassPOO;

public class EmpleadoDespegar implements Strategy {

	private static double IndiceDeBonificacion = 0.7;

	public static void setIndiceDeBonificacion(Double unIndice) {
		IndiceDeBonificacion = unIndice;
	}

	public double getIndiceDeBonificacion() {
		return IndiceDeBonificacion;
	}
	
	public double calcularPrecio(double precio){
		return (precio * IndiceDeBonificacion);
	}

}
