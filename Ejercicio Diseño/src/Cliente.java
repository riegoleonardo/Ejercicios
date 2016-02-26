
public class Cliente {
	private double saldo;
	private double gastosTotales;
	Paquete paqueteMasCaro;
	Integer cantidadDePaquetesComprados;

	
	
	public Cliente() {
		saldo = 0;
		gastosTotales = 0;
		paqueteMasCaro = null;
		cantidadDePaquetesComprados = 0;
	}
	
	public Cliente (double sueldo) {
		saldo = sueldo;	
		gastosTotales = 0;
		paqueteMasCaro = null;
		cantidadDePaquetesComprados = 0;
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
	
	public void restarSaldo (Double monto) {
		saldo = saldo - monto;
		gastosTotales+=monto;
	}
	
	public Double getGastosTotales() {
		return gastosTotales;
	}
	
	public void setPaqueteMasCaro(Paquete unPaquete) {
		if (paqueteMasCaro != null) {
			if ( paqueteMasCaro.precioPaquete() < unPaquete.precioPaquete()) {
				paqueteMasCaro = unPaquete;
			}
		} else {
			paqueteMasCaro = unPaquete;
		}
	}
	
	public void comprarPaquete(Paquete unPaquete) {
		this.restarSaldo(unPaquete.precioPaquete());
		this.setPaqueteMasCaro(unPaquete);
		cantidadDePaquetesComprados++;
	}
	
	
	

}
