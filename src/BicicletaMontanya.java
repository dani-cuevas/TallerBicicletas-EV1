public class BicicletaMontanya extends Bicicleta {

    private int cantidadSuspensiones;

    public BicicletaMontanya(String codigoBicicleta,
                             int anioFabricacion,
                             double pesoKg,
                             int cantidadSuspensiones) {

        super(codigoBicicleta, anioFabricacion, pesoKg);

        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    public int getCantidadSuspensiones() {
        return cantidadSuspensiones;
    }

    public void setCantidadSuspensiones(int cantidadSuspensiones) {
        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    @Override
    public double calcularCostoMantencion() {

        double costo = 30000;

        if (cantidadSuspensiones > 1) {
            costo = costo + (costo * 15 / 100);
        }

        return costo;
    }
}
