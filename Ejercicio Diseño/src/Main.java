
public class Main {
		
	public static void main(String args[]){
		/*Primer grupo de pruebas */
		Cliente juan = new Cliente( 2000.0);
		PaqueteEstandar paqueteEstandar = new PaqueteEstandar(500.0, 25.0);
		
		juan.comprarPaquete(paqueteEstandar);
		System.out.println(juan.getSaldoActual());
		juan.setSaldoActual(2000.0);
		paqueteEstandar.setPrecioBase(100.0);
		juan.comprarPaquete(paqueteEstandar);
		System.out.println(juan.getSaldoActual());
		System.out.println(juan.getGastosTotales());
		/*Fin Pruebas*/
	}		
}
