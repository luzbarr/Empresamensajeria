public class EnvioAereo extends Envio {

    public EnvioAereo(String codigo, String destino,
                      double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    @Override
    public double calcularCosto() {
        double costo = 20000
                + peso * 4000
                + distancia * 600;

        if (peso > 10) {
            costo = costo + costo * 0.20;
        }

        if (distancia > 1000) {
            costo = costo - costo * 0.05;
        }

        return costo;
    }

    @Override
    public int calcularTiempoEntrega() {
        if (distancia <= 500) {
            return 1;
        } else if (distancia <= 1500) {
            return 2;
        } else {
            return 3;
        }
    }
}
