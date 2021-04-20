package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Set;
import negocio.Funciones;

//  Implementar equals, agregar y eliminar cliente

public class Evento {
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes;

	public Evento() {
	}

	public Evento(String evento, LocalDate fecha,LocalTime hora) {
		super();
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	public boolean agregar(Cliente cliente) {
				
	return clientes.add(cliente);
		
	}

	public boolean eliminar(Cliente cliente) {
		
		return clientes.remove(cliente);
	}

	
	
public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEvento ^ (idEvento >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		return idEvento == ((Evento)obj).getIdEvento();
	}


public String toString(){
return idEvento+" "+evento+" "+Funciones.traerFechaCorta(fecha)+" "+Funciones.traerHoraCorta(hora); //
}


	
}