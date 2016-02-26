
public class PaqueteHabitaciones implements Paquete {
	private Integer cantidadHabitaciones;
	private Double precioPorHabitacion;
	private Double impuesto;
	
	public PaqueteHabitaciones(Integer unaCantidad, Double unPrecio, Double unImpuesto) {
		cantidadHabitaciones = unaCantidad;
		precioPorHabitacion = unPrecio;
		impuesto = unImpuesto;
	}
	
	public Integer getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}
	public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}
	public Double getPrecioPorHabitacion() {
		return precioPorHabitacion;
	}
	public void setPrecioPorHabitacion(Double precioPorHabitacion) {
		this.precioPorHabitacion = precioPorHabitacion;
	}
	
	public double precioPaquete() {
		return (cantidadHabitaciones * precioPorHabitacion) * (1 + impuesto/100);
	}
	
	
	
}
