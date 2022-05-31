package co.uniquindio.proyectoFinal.Utilidades;

import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;

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

    public static void validarSiNuloOrVacio (String a) throws StringNuloOrVacioException {
        if (a==null || a.equals(""))
            throw new StringNuloOrVacioException("El String pasado es nulo");
    }

    public static void validarSiNuloOrVacio (String a, String b) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d, String e) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals("")|| e==null || e.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d, String e, String f) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals("")|| e==null || e.equals("") || f==null || f.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d, String e, String f, String g) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals("")|| e==null || e.equals("") || f==null || f.equals("") || g==null || g.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d, String e, String f, String g, String h) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals("")|| e==null || e.equals("") || f==null || f.equals("") || g==null || g.equals("") || h==null || h.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    public static void validarSiNuloOrVacio (String a, String b, String c, String d, String e, String f, String g, String h, String i) throws StringNuloOrVacioException {
        if (a==null || a.equals("") || b==null || b.equals("")|| c==null || c.equals("")|| d==null || d.equals("")|| e==null || e.equals("") || f==null || f.equals("") || g==null || g.equals("") || h==null || h.equals("") || i==null || i.equals(""))
            throw new StringNuloOrVacioException("Uno o más Strings son nulos o están vacíos");
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public static boolean esNuloOrVacio (String a){
        return a == null || a.equals("");
    }

    public static boolean esNuloOrVacio (String a, String b){
        return a == null || a.equals("") || b == null || b.equals("");
    }

    public static boolean esNuloOrVacio (String a, String b, String c){
        return a == null || a.equals("") || b == null || b.equals("") || c == null || c.equals("");
    }

    public static boolean esNuloOrVacio (String a, String b, String c, String d){
        return a == null || a.equals("") || b == null || b.equals("") || c == null || c.equals("") || d == null || d.equals("");
    }

    public static boolean esNuloOrVacio (String a, String b, String c, String d, String e){
        return a == null || a.equals("") || b == null || b.equals("") || c == null || c.equals("") || d == null || d.equals("") || e == null || e.equals("");
    }

    public static boolean esNuloOrVacio (String a, String b, String c, String d, String e, String f){
        return a == null || a.equals("") || b == null || b.equals("") || c == null || c.equals("") || d == null || d.equals("") || e == null || e.equals("") || f == null || f.equals("");
    }
}
