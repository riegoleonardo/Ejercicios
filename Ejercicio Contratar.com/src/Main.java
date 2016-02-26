
public class Main {

	public static void main (String args[]) {			
			Empresa unaEmpresa = new Empresa (500.0, 45, "Pepito");
			Gerente categoriaGerente = new Gerente();
			Usuario usuarioPepito = new Usuario(5000.0, categoriaGerente, unaEmpresa, 35);
			Empresa otraEmpresa = new Empresa (8000000.0, 500, "Pepita");
			System.out.println(usuarioPepito.getSueldoEsperado(otraEmpresa));	
			usuarioPepito.cambiarTrabajo(8000000.0, otraEmpresa);
			usuarioPepito.mostrarHistorialDeEmpresas();
			Usuario otroUsuario = new Usuario();
			otroUsuario.mostrarHistorialDeEmpresas();
		}
}
