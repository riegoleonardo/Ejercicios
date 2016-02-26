
public class PaqueteHabitaciones implements Paquete {
	private Integer cantidadHabitaciones;
	private Double precioPorHabitacion;
	
	public PaqueteHabitaciones(Integer unaCantidad, Double unPrecio) {
		cantidadHabitaciones = unaCantidad;
		precioPorHabitacion = unPrecio;
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
		return cantidadHabitaciones * precioPorHabitacion;
	}
	
	
	
}
