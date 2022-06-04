package co.uniquindio.proyectoFinal.model.enums;

public enum MetodoPago {

    DEBITO (0),CREDITO (1),CORRIENTE (2);

    private int numTipo;

    MetodoPago(int numTipo) {
        this.numTipo = numTipo;
    }

    public int getNumTipo() {
        return numTipo;
    }

}
