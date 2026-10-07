import java.util.List;

public class Main {

    public static void main(String[] args) {

        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        BicicletaElectrica bicicletaE01 = new BicicletaElectrica(
                "BIC-E01",
                2023,
                22.5,
                60,
                false
        );

        BicicletaElectrica bicicletaE02 = new BicicletaElectrica(
                "BIC-E02",
                2022,
                24.0,
                45,
                true
        );

        BicicletaMontanya bicicletaM01 = new BicicletaMontanya(
                "BIC-M01",
                2021,
                13.5,
                2
        );

        BicicletaMontanya bicicletaM02 = new BicicletaMontanya(
                "BIC-M02",
                2020,
                12.0,
                1
        );

        bicicletaE01.activarGarantiaExtendida();

        gestor.registrarBicicleta(bicicletaE01);
        gestor.registrarBicicleta(bicicletaE02);
        gestor.registrarBicicleta(bicicletaM01);
        gestor.registrarBicicleta(bicicletaM02);

        System.out.println();
        System.out.println("=== BUSQUEDA POR CODIGO: BIC-E01 ===");

        List<Bicicleta> resultados =
                gestor.buscarPorCodigo("BIC-E01");

        for (Bicicleta bicicleta : resultados) {

            System.out.println(
                    "Tipo: " + bicicleta.getClass().getSimpleName()
            );

            System.out.println(
                    "Codigo: " + bicicleta.getCodigoBicicleta()
            );

            System.out.println(
                    "Año: " + bicicleta.getAnioFabricacion()
            );

            System.out.println(
                    "Peso: " + bicicleta.getPesoKg() + " kg"
            );

            if (bicicleta instanceof BicicletaElectrica) {

                BicicletaElectrica electrica =
                        (BicicletaElectrica) bicicleta;

                System.out.println(
                        "Autonomia: "
                                + electrica.getAutonomiaKm()
                                + " km"
                );

                System.out.println(
                        "Bateria certificada: "
                                + electrica.isBateriaCertificada()
                );

                System.out.println(
                        "Garantia extendida activa: "
                                + electrica.tieneGarantiaExtendidaActiva()
                );
            }

            System.out.println(
                    "Costo mantencion: $"
                            + bicicleta.calcularCostoMantencion()
            );
        }

        System.out.println();
        System.out.println("=== LISTADO DE BICICLETAS ===");

        for (Bicicleta bicicleta : gestor.obtenerBicicletas()) {
            System.out.println(bicicleta);
        }
    }
}