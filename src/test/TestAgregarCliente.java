
package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {

    public static void main(String[] args) {

        ClienteABM abm = new ClienteABM();
        String nombre = "Pimplin";
        String apellido = "Zarate";
        int dni = 444;
        LocalDate nacimiento = LocalDate.of(1995, 5, 5);

        try {
            abm.agregar(apellido, nombre, dni, nacimiento);
            System.out.println("El Cliente se agrego con Exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}