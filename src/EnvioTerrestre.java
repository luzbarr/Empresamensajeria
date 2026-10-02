public class EnvioTerrestre extends Envio {

    private double costoBase = 8000;

    public EnvioTerrestre(String codigo, String destino,
                          double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    @Override
    public double calcularCosto() {
        double costoTotal = costoBase
                + (peso * 1500)
                + (distancia * 400);

        if (peso > 20) {
            costoTotal = costoTotal + costoTotal * 0.10;
        }

        if (distancia > 500) {
            costoTotal = costoTotal + costoTotal * 0.15;
        }

        return costoTotal;
    }

    @Override
    public int calcularTiempoEntrega() {
        if (distancia <= 200) {
            return 1;
        } else if (distancia <= 500) {
            return 2;
        } else if (distancia <= 1000) {
            return 3;
        } else {
            return 5;
        }
    }
}