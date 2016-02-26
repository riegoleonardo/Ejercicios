	
public class PaqueteEstandar implements Paquete{
		
	private Double precioBase;
	private Double impuesto;
	
	public PaqueteEstandar(Double unPrecio, Double unImpuesto) {
		precioBase = unPrecio;
		impuesto = unImpuesto;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public double precioPaquete() {
		return (precioBase * (1 + impuesto/100)) ;
	}
	
}
