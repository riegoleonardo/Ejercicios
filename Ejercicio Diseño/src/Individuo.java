import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Individuo extends Cliente {

	Paquete paqueteReservado;
	private final static Logger LOGGER = LoggerFactory.getLogger(Cliente.class);

	public void reservarPaquete(Paquete unPaquete) {
		try {
			this.restarSaldo(unPaquete.precioPaquete() / 2);
		} catch (Exception e) {
			LOGGER.error("Saldo Insuficiente", e);
		} finally {
			System.out.println(saldo);
		}
	}

	public void comprarPaqueteReservado() {
		try {
			this.restarSaldo(paqueteReservado.precioPaquete() / 2);
			this.setPaqueteMasCaro(paqueteReservado);
			cantidadDePaquetesComprados++;
		} catch (Exception e) {
			LOGGER.error("Saldo insuficiente", e);
		} finally {
			System.out.println(saldo);
		}

	}

}
