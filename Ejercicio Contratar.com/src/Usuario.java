import java.util.LinkedList;

public class Usuario {
	
	private Double sueldoActual;
	private Categoria categoria;
	private Empresa empresaActual;
	private Integer aniosDeExperiencia;
	private LinkedList<Empresa> historialDeEmpresas = new LinkedList<Empresa>();
	
	public Usuario (Double unSueldo, Categoria unaCategoria, Empresa unaEmpresa, Integer anios) {
		sueldoActual = unSueldo;
		categoria = unaCategoria;
		empresaActual = unaEmpresa;
		aniosDeExperiencia = anios;
		historialDeEmpresas.add(unaEmpresa);
	}
	
	public Usuario(){
		sueldoActual = 0.0;
		categoria = new Trainee();
		empresaActual = null;
		aniosDeExperiencia = 0;
	}
	
	public void escucharOferta( Double unSueldo, Empresa unaEmpresa) {
		if (unSueldo >= this.getSueldoEsperado(unaEmpresa)) {
			this.cambiarTrabajo (unSueldo, unaEmpresa);
		}
	}
	
	public void cambiarTrabajo (Double unSueldo, Empresa unaEmpresa) {
		if (empresaActual != null){
			empresaActual.quitarEmpleado();
		}
		sueldoActual = unSueldo;
		empresaActual = unaEmpresa;
		empresaActual.sumarEmpleado();
		historialDeEmpresas.add(empresaActual);
	}
	
	public void mostrarHistorialDeEmpresas () {
		if (historialDeEmpresas.isEmpty()) {
			System.out.println("El usuario no ha trabajado en ninguna empresa");
		} else {
			for (int i = 0; i < historialDeEmpresas.size(); i++) {
				System.out.println(historialDeEmpresas.get(i).getNombre());
			}
		}
	}
	
	public Double getSueldoEsperado (Empresa unaEmpresa) {		
		return categoria.sueldoPromedio(unaEmpresa, this);
	}
	
	public Integer getAniosDeExperiencia(){
		return aniosDeExperiencia;
	}
	
	public Double getSueldoActual() {
		return sueldoActual;
	}
	public void setSueldoActual(Double sueldoActual) {
		this.sueldoActual = sueldoActual;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Empresa getEmpresaActual() {
		return empresaActual;
	}
	public void setEmpresaActual(Empresa empresaActual) {
		this.empresaActual = empresaActual;
	}
	
	
	
	

}
