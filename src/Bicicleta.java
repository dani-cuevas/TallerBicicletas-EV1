public abstract class Bicicleta {

    private String codigoBicicleta;
    private int anioFabricacion;
    private double pesoKg;

    public Bicicleta(String codigoBicicleta,
                     int anioFabricacion,
                     double pesoKg) {

        setCodigoBicicleta(codigoBicicleta);
        setAnioFabricacion(anioFabricacion);
        setPesoKg(pesoKg);
    }

    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    public void setCodigoBicicleta(String codigoBicicleta) {

        if (codigoBicicleta == null || codigoBicicleta.isEmpty()) {
            throw new IllegalArgumentException(
                    "El codigo de bicicleta no puede estar vacio."
            );
        }

        this.codigoBicicleta = codigoBicicleta;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {

        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException(
                    "El año debe estar entre 2000 y 2026."
            );
        }

        this.anioFabricacion = anioFabricacion;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {

        if (pesoKg <= 0) {
            throw new IllegalArgumentException(
                    "El peso debe ser mayor que cero."
            );
        }

        this.pesoKg = pesoKg;
    }

    public abstract double calcularCostoMantencion();

    public double calcularCostoMantencion(double porcentajeDescuento) {

        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100."
            );
        }

        double costo = calcularCostoMantencion();
        double descuento = costo * porcentajeDescuento / 100;

        return costo - descuento;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigoBicicleta +
                " | Año: " + anioFabricacion;
    }
}