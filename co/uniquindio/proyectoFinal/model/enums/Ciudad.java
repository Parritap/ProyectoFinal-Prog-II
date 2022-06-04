package co.uniquindio.proyectoFinal.model.enums;

public enum Ciudad {

    ARMENIA("AXM"),
    BOGOTA ("BOG"),
    MEDELLIN ("MDE"),
    CALI ("CLO");


    String abreviatura;

    Ciudad (String abreviatura){
        this.abreviatura = abreviatura;
    }
}
