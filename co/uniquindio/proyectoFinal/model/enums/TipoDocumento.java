package co.uniquindio.proyectoFinal.model.enums;

public enum TipoDocumento {
    TARJETA_IDENTIDAD (0),CEDULA_CIUDADANIA (1),CEDULA_EXTRANJERIA (2);

    private int numTipo;

    TipoDocumento(int numTipo) {
        this.numTipo = numTipo;
    }

    public int getNumTipo() {
        return numTipo;
    }

}
