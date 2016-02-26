import java.util.Collection;

public class Empresa extends Cliente {

	public void comprarMuchosPaquetes(Collection<Paquete> conjuntoDePaquetes) {
		for (Paquete unPaquete : conjuntoDePaquetes) {
			this.comprarPaquete(unPaquete);
		}
	}
}
