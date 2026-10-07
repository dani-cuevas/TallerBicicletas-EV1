import java.util.List;

public class Main {

    public static void main(String[] args) {

        LecturaEntrada lector = new LecturaEntrada();
        GestorTallerBicicletas gestor =
                new GestorTallerBicicletas();

        BicicletaElectrica bicicletaE01 =
                new BicicletaElectrica(
                        "BIC-E01",
                        2023,
                        22.5,
                        60,
                        false
                );

        BicicletaElectrica bicicletaE02 =
                new BicicletaElectrica(
                        "BIC-E02",
                        2022,
                        24.0,
                        45,
                        true
                );

        BicicletaMontanya bicicletaM01 =
                new BicicletaMontanya(
                        "BIC-M01",
                        2021,
                        13.5,
                        2
                );

        BicicletaMontanya bicicletaM02 =
                new BicicletaMontanya(
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
        System.out.println(
                "=== BUSQUEDA POR CODIGO: BIC-E01 ==="
        );

        List<Bicicleta> resultadoOficial =
                gestor.buscarPorCodigo("BIC-E01");

        for (Bicicleta bicicleta : resultadoOficial) {

            System.out.println(
                    "Tipo: "
                            + bicicleta.getClass().getSimpleName()
            );

            System.out.println(
                    "Codigo: "
                            + bicicleta.getCodigoBicicleta()
            );

            System.out.println(
                    "Año: "
                            + bicicleta.getAnioFabricacion()
            );

            System.out.println(
                    "Peso: "
                            + bicicleta.getPesoKg()
                            + " kg"
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
                        "Garantia extendida: "
                                + electrica
                                .tieneGarantiaExtendidaActiva()
                );
            }

            System.out.println(
                    "Costo mantencion: $"
                            + bicicleta
                            .calcularCostoMantencion()
            );
        }

        System.out.println();
        System.out.println(
                "=== LISTADO DE BICICLETAS ==="
        );

        for (Bicicleta bicicleta :
                gestor.obtenerBicicletas()) {

            System.out.println(bicicleta);
        }

        int opcion;

        do {

            System.out.println();
            System.out.println(
                    "===== TALLER DE BICICLETAS ====="
            );
            System.out.println(
                    "1. Listar todas las bicicletas"
            );
            System.out.println(
                    "2. Buscar bicicleta por codigo"
            );
            System.out.println(
                    "3. Simular mantencion con descuento"
            );
            System.out.println(
                    "4. Salir"
            );

            opcion = lector.leerEnteroEnRango(
                    "Seleccione una opcion: ",
                    1,
                    4
            );

            switch (opcion) {

                case 1:

                    System.out.println();
                    System.out.println(
                            "=== LISTADO ==="
                    );

                    for (Bicicleta bicicleta :
                            gestor.obtenerBicicletas()) {

                        System.out.println(bicicleta);
                    }

                    break;

                case 2:

                    String codigo =
                            lector.leerTextoNoVacio(
                                    "Ingrese codigo: "
                            );

                    List<Bicicleta> encontrados =
                            gestor.buscarPorCodigo(codigo);

                    if (encontrados.isEmpty()) {

                        System.out.println(
                                "No se encontro la bicicleta."
                        );

                    } else {

                        for (Bicicleta bicicleta :
                                encontrados) {

                            System.out.println(bicicleta);

                            System.out.println(
                                    "Costo mantencion: $"
                                            + bicicleta
                                            .calcularCostoMantencion()
                            );
                        }
                    }

                    break;

                case 3:

                    String codigoDescuento =
                            lector.leerTextoNoVacio(
                                    "Ingrese codigo de bicicleta: "
                            );

                    List<Bicicleta> bicicletasDescuento =
                            gestor.buscarPorCodigo(
                                    codigoDescuento
                            );

                    if (bicicletasDescuento.isEmpty()) {

                        System.out.println(
                                "No se encontro la bicicleta."
                        );

                    } else {

                        double porcentaje =
                                lector.leerDoubleEnRango(
                                        "Ingrese porcentaje de descuento: ",
                                        0,
                                        100
                                );

                        for (Bicicleta bicicleta :
                                bicicletasDescuento) {

                            System.out.println(
                                    "Costo normal: $"
                                            + bicicleta
                                            .calcularCostoMantencion()
                            );

                            System.out.println(
                                    "Costo con descuento: $"
                                            + bicicleta
                                            .calcularCostoMantencion(
                                                    porcentaje
                                            )
                            );
                        }
                    }

                    break;

                case 4:

                    System.out.println(
                            "Saliendo del sistema."
                    );

                    break;
            }

        } while (opcion != 4);
    }
}