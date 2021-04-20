package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import dao.EventoDao;
import datos.Evento;

public class EventoABM {

    EventoDao e = new EventoDao();

    public int agregar (String evento,LocalDate fecha,LocalTime hora) {

        EventoDao e = new EventoDao();
        return e.agregar(new Evento(evento, fecha,hora));
    }

    public Evento traer(long idEvento) {

    return e.traer(idEvento);

    }


}