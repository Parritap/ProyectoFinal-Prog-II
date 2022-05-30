package co.uniquindio.proyectoFinal.exceptions;

public class StringVacioException extends Exception {
    public StringVacioException(String s) {
        super(s);
    }

    public StringVacioException() {
        super();
    }
}
