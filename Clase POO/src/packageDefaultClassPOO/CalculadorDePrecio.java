package packageDefaultClassPOO;

public class CalculadorDePrecio {

	public double calcularPrecio(Cliente unaPersona, double precio) {
		double precioFinal = unaPersona.calcularPrecioFinal(precio);
		return precioFinal * 1.21;
	}
}
