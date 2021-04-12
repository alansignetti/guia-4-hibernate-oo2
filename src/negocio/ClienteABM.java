package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.ClienteDao;
import datos.Cliente;
import datos.Prestamo;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traerPorId(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente c = null;
    	
   	 if (dao.traer(dni) == null){ // si no trae ningun objeto, significa que no esta cargado ese dni y lo agrega

      	  		c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
   	 }
   	 else {
   		 throw new Exception("El dni ingresado ya existe en la base de datos");	
   	 }	
       
       return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
		Cliente cliDni = new Cliente();
    	Cliente cliId = new Cliente();
    	cliDni= dao.traer(c.getDni()); 
    	cliId = dao.traer(c.getIdCliente());
    	// el c.dni != dliID.dni
    	if (cliDni == null & cliId.getDni() != c.getDni()) { // no existe un cliente con ese dni, y tampoco con ese id para ese dni    		
    			dao.actualizar(c);		
		}
    	else {
    		throw new Exception("No se pudo modificar debido a que ese DNI ya existe en la Base de Datos");	
    	}
	}

	public void eliminar(long idCliente) {
		Cliente c = dao.traer(idCliente);
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) throws Exception {

		Cliente c = dao.traer(idCliente);

		Set<Prestamo> listaPrestamo = c.getPrestamos();
		if (listaPrestamo == null || listaPrestamo.isEmpty()) {
			throw new Exception("El cliente " + c.getNombre() + " no tiene ningun prestamo");
		} else {
			return dao.traerClienteYPrestamos(idCliente);
		}
	}
}
