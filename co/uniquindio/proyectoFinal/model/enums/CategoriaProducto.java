package co.uniquindio.proyectoFinal.model.enums;

public enum CategoriaProducto {

    TECNOLOGIA_MOVIL (0),TECNOLOGIA_COMPUTACIONAL (1),CEDULA_EXTRANJERIA (2);

    private int numTipo;

    CategoriaProducto(int numTipo) {
        this.numTipo = numTipo;
    }

    public int getNumTipo() {
        return numTipo;
    }
}
