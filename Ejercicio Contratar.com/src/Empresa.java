
public class Empresa {
	
	private Double sueldoBase;
	private Integer cantidadDeEmpleados;
	private String nombre;
	
	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public Empresa (Double unSueldo, Integer unosEmpleados, String unNombre) {
		sueldoBase = unSueldo;
		cantidadDeEmpleados = unosEmpleados;
		nombre = unNombre;
	}
	
	public Double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(Double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public Integer getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}
	public void setCantidadDeEmpleados(Integer cantidadDeEmpleados) {
		this.cantidadDeEmpleados = cantidadDeEmpleados;
	}

	public void quitarEmpleado() {
		cantidadDeEmpleados--;
		
	}

	public void sumarEmpleado() {
		cantidadDeEmpleados++;
		
	}
	
}
