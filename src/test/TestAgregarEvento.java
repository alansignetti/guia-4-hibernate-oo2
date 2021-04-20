
package test;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.EventoABM;

public class TestAgregarEvento {

    public static void main(String[] args) {


        EventoABM evento = new EventoABM();

        String nombre= "Evento de tu tia";
        LocalDate fecha = LocalDate.of(2021, 03, 12);
        LocalTime hora = LocalTime.of(11, 11);

        evento.agregar(nombre, fecha,hora);
        System.out.println("El evento se agrego exitosamente");

    }

}