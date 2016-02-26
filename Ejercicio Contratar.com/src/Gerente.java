
public class Gerente implements Categoria{

	
	public Double sueldoPromedio(Empresa unaEmpresa, Usuario unUsuario) {
	
		return ((unaEmpresa.getCantidadDeEmpleados() / 10) * unUsuario.getSueldoActual());
	
	}
	

}
