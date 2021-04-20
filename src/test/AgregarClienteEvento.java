package test;

import datos.Cliente;
import negocio.ClienteABM;

public class AgregarClienteEvento {

	public static void main(String[] args) {
		
		ClienteABM cliente = new ClienteABM();
		
		cliente.AgregarClienteAEvento(1, 3);

//        System.out.println("Se agrego el cliente al evento");
		
		Cliente c = cliente.traerClienteYEventos(1);
		
		System.out.println(c);

	}

}
