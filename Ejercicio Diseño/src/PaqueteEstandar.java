	
public class PaqueteEstandar implements Paquete{
		
	private Double precioBase;
	
	public PaqueteEstandar(Double unPrecio) {
		precioBase = unPrecio;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public double precioPaquete() {
		return precioBase;
	}
	
}
