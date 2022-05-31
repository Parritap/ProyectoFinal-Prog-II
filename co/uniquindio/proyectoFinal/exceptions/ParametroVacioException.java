package co.uniquindio.proyectoFinal.exceptions;

public class ParametroVacioException extends Exception{
    public ParametroVacioException(String s) {
        super(s);
    }

    public ParametroVacioException (){
        super();
    }
}
