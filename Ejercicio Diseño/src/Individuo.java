
public class Individuo extends Cliente {

	Paquete paqueteReservado;
	
	public void reservarPaquete(Paquete unPaquete) {
		this.restarSaldo(unPaquete.precioPaquete()/2);
		if (paqueteReservado == null) {
			paqueteReservado = unPaquete;
		} else {
			System.out.println("No puede reservar más de un paquete");
		}
	}
	
	public void comprarPaqueteReservado() {
		this.restarSaldo(paqueteReservado.precioPaquete()/2);
		this.setPaqueteMasCaro(paqueteReservado);
		cantidadDePaquetesComprados++;
		
	}
	
	
}
