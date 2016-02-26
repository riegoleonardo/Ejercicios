package packageDefaultClassPOO;

public class Cliente {

	private String nombre;
	Strategy tipoDeCliente;
	
	private Cliente() {
		
	}
	
	public Cliente (String unNombre, Strategy unTipo) {
		nombre = unNombre;
		tipoDeCliente = unTipo;
	}
	
	public void setTipo(Strategy unTipo) {
		tipoDeCliente = unTipo;
	}

	public double getIndiceDeBonificacion(){
		return tipoDeCliente.getIndiceDeBonificacion();
	};

	public double calcularPrecioFinal(double precio) {
		return (tipoDeCliente.calcularPrecio(precio) * 1.21);
	};

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String unNombre) {
		nombre = unNombre;
	}

}
