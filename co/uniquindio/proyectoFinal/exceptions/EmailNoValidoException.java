package co.uniquindio.proyectoFinal.exceptions;

public class EmailNoValidoException extends Exception{

    public EmailNoValidoException (){
        super();
    }

    public EmailNoValidoException (String str){
        super(str);
    }
}
