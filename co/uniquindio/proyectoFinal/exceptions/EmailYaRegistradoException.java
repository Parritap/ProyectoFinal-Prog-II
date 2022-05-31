package co.uniquindio.proyectoFinal.exceptions;

public class EmailYaRegistradoException extends Exception{
    public EmailYaRegistradoException(String s) {
        super(s);
    }

    public EmailYaRegistradoException() {
        super();
    }
}
