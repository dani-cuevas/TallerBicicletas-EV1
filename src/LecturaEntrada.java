import java.util.Scanner;

public class LecturaEntrada {

    private Scanner scanner;

    public LecturaEntrada() {
        scanner = new Scanner(System.in);
    }

    public String leerTextoNoVacio(String mensaje) {

        System.out.print(mensaje);
        String texto = scanner.nextLine();

        while (texto.trim().isEmpty()) {
            System.out.println("El texto no puede estar vacio.");
            System.out.print(mensaje);
            texto = scanner.nextLine();
        }

        return texto;
    }

    public int leerEnteroEnRango(String mensaje, int minimo, int maximo) {

        int numero = 0;
        boolean valido = false;

        while (valido == false) {

            System.out.print(mensaje);
            String texto = scanner.nextLine();

            try {

                numero = Integer.parseInt(texto);

                if (numero >= minimo && numero <= maximo) {
                    valido = true;
                } else {
                    System.out.println(
                            "El valor debe estar entre "
                                    + minimo + " y " + maximo + "."
                    );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un numero entero."
                );
            }
        }

        return numero;
    }

    public double leerDoubleEnRango(
            String mensaje,
            double minimo,
            double maximo) {

        double numero = 0;
        boolean valido = false;

        while (valido == false) {

            System.out.print(mensaje);
            String texto = scanner.nextLine();

            try {

                numero = Double.parseDouble(texto);

                if (numero >= minimo && numero <= maximo) {
                    valido = true;
                } else {
                    System.out.println(
                            "El valor debe estar entre "
                                    + minimo + " y " + maximo + "."
                    );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un numero."
                );
            }
        }

        return numero;
    }
}
