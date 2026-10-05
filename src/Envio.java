public abstract class Envio {

    protected String codigo;
    protected String destino;
    protected double peso;
    protected double distancia;

    public String getcodigo() {
        return codigo;
    }

    public Envio(String codigo, String destino, double peso, double distancia) {
        this.codigo = codigo;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
    }

    public abstract double calcularCosto();

    public abstract int calcularTiempoEntrega();

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Destino: " + destino);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Costo: $" + calcularCosto());
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " días");
    }
































































































}
