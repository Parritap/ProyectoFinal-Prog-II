package co.uniquindio.proyectoFinal.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomTest {

    public static void main(String[] args) {

        System.out.println(obtenerFechaActual());
    }



    private static  String obtenerFechaActual() {
        Date date = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat ("dd/MM/yyyy");
        String fechaFormateada = sfd.format(date);
        return fechaFormateada;
    }
}
