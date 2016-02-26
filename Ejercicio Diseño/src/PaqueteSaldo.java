
public class PaqueteSaldo implements Paquete {
	
	private Cliente cliente;
	private Double impuesto;
	
	public PaqueteSaldo(Cliente unCliente, Double unImpuesto) {
		cliente = unCliente;
		impuesto = unImpuesto;
	}

	public double precioPaquete() {
		return ((cliente.getSaldoActual()*1.10) * (1 + impuesto / 100));
	}
	
	public void setCliente (Cliente unCliente) {
		cliente = unCliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
}
