
public class Main {
		
	public static void main(String args[]){
		/*Primer grupo de pruebas */
		Cliente juan = new Cliente( 2000.0);
		PaqueteEstandar paqueteEstandar = new PaqueteEstandar(500.0);
		
		juan.comprarPaquete(paqueteEstandar, 25.0);
		System.out.println(juan.getSaldoActual());
		juan.setSaldoActual(2000.0);
		paqueteEstandar.setPrecioBase(100.0);
		juan.comprarPaquete(paqueteEstandar, 10.0);
		System.out.println(juan.getSaldoActual());
		/*Fin Pruebas*/
	}		
}
