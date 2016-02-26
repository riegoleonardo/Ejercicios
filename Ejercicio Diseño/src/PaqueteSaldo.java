
public class PaqueteSaldo implements Paquete {
	
	private Cliente cliente;
	
	public PaqueteSaldo(Cliente unCliente) {
		cliente = unCliente;
	}

	public double precioPaquete() {
		return cliente.getSaldoActual()*1.10;
	}
	
	public void setCliente (Cliente unCliente) {
		cliente = unCliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
}
