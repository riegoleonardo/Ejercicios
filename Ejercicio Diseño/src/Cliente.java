
public class Cliente {
	private double saldo;
	private double gastosTotales;
	Paquete paqueteMasCaro;
	
	
	public Cliente() {
		saldo = 0;
		gastosTotales = 0;
		paqueteMasCaro = null;
	}
	
	public Cliente (double sueldo) {
		saldo = sueldo;	
		gastosTotales = 0;
		paqueteMasCaro = null;
	}
	
	public double getSaldoActual() {
		return saldo;
	}
	
	public void setSaldoActual( double unSaldo) {
		saldo = unSaldo;
	}
	
	public Paquete getPaqueteMasCaro() {
		return paqueteMasCaro;
	}
	
	public void restarSaldo (Double monto, Double impuesto) {
		Double precioDelPaquete = monto * (1+(impuesto/100));
		gastosTotales = gastosTotales + precioDelPaquete;
		saldo = saldo - precioDelPaquete;
	}
	
	public void comprarPaquete(Paquete unPaquete, Double impuesto) {
		this.restarSaldo(unPaquete.precioPaquete(), impuesto);
		if (paqueteMasCaro != null) {
			if ( paqueteMasCaro.precioPaquete() < unPaquete.precioPaquete()) {
				paqueteMasCaro = unPaquete;
			}
		} else {
			paqueteMasCaro = unPaquete;
		}
	}
	
	
	

}
