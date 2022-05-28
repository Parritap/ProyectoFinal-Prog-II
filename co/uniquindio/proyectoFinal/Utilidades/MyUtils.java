package co.uniquindio.proyectoFinal.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {


    /**
     * Método que evalúa si un email es valido mediante expresiones regulares.
     * @param email String a evaluar.
     * @return True si el email es valido; false de lo contrario.
     * FUENTE DEL REGEX: <a href="https://stackoverflow.com/questions/201323/how-can-i-validate-an-email-address-using-a-regular-expression">...</a>
     */
    public static boolean esEmailValido (String email){

        if (email==null)
            throw new NullPointerException("El email pasado es nulo");


        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return (matcher.matches());
    }


    /**
     * Método que re
     * @param str String a evaluar.
     * @return El String pasado en el argumento intacto si este no es nulo, de lo contrario lo convierte a uno vacío.
     */
    public static String redefinirString (String str){
        if (str==null)
            return "";
        return str;
    }
}
