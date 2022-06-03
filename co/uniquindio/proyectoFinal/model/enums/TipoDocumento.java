package co.uniquindio.proyectoFinal.model.enums;

public enum TipoDocumento {
    CEDULA (0),TARJETA_IDENTIDAD (1), CEDULA_EXTRANJERIA(2);


    private int numTipo;


    TipoDocumento(int numTipo) {
        this.numTipo = numTipo;
    }

    public int getNumTipo() {
        return numTipo;
    }

}
