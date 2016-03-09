import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cliente {
	protected double saldo;
	private double gastosTotales;
	Paquete paqueteMasCaro;
	Integer cantidadDePaquetesComprados;
	private final static Logger LOGGER = LoggerFactory.getLogger(Cliente.class);

	
	
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
	
	public void restarSaldo (Double monto){
		if(saldo < monto) {
				throw new SaldoInsuficienteException("El saldo es insuficiente para realizar la operacion solicitada.");
		}
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
		try {
			this.restarSaldo(unPaquete.precioPaquete());
			this.setPaqueteMasCaro(unPaquete);
			cantidadDePaquetesComprados++;
		} catch (SaldoInsuficienteException e){
			LOGGER.error("Cuenta sin saldo", e);
		} finally {
			System.out.println(saldo);
		}
	}
	
	
	

}
