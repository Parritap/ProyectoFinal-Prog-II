package co.uniquindio.proyectoFinal.test;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;

public class MyUtilsTest {

    public static void main(String[] args) {
        String email = "juan.parra@uqvirtual.edu.co";
        boolean mailValido = MyUtils.esEmailValido(email);
        System.out.println(mailValido);


        String n = null;
        System.out.println(MyUtils.redefinirString(n));
    }
}
