import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {

    private List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        bicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta bicicleta) {

        bicicletas.add(bicicleta);

        System.out.println(
                bicicleta.getCodigoBicicleta()
                        + " registrada correctamente."
        );
    }

    public List<Bicicleta> buscarPorCodigo(String criterio) {

        List<Bicicleta> resultados = new ArrayList<>();

        for (Bicicleta bicicleta : bicicletas) {

            if (bicicleta.getCodigoBicicleta()
                    .equalsIgnoreCase(criterio)) {

                resultados.add(bicicleta);
            }
        }

        return resultados;
    }

    public List<Bicicleta> obtenerBicicletas() {
        return new ArrayList<>(bicicletas);
    }
}
