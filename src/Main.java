import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Envio> lstEnvios = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        int opcion = 0;
        boolean salir = false;

        do {
            System.out.println("\n*****INFORMATE SOBRE TU ENVIO*****");
            System.out.println("1. Registre su EnvioTerrestre");
            System.out.println("2. Registre su EnvioAereo");
            System.out.println("3. Ver todos los envios");
            System.out.println("4. Busca tu Envio por codigo");
            System.out.println("5. Envio mas costoso");
            System.out.println("6. Calcular total recaudado");
            System.out.println("7. Mostrar Informacion");
            System.out.println("8. Salir");
            System.out.println("Seleccione opcion:");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer tras leer la opción
            } else {
                System.out.println("Opción inválida. Ingrese un número.");
                teclado.nextLine();
                continue;
            }

            switch (opcion) {
                case 1: {
                    System.out.println("INGRESE EL CÓDIGO:");
                    String codigo = teclado.nextLine();

                    System.out.println("INGRESE EL DESTINO:");
                    String destino = teclado.nextLine();

                    System.out.println("INGRESE EL PESO EN KG:");
                    double peso = teclado.nextDouble();

                    System.out.println("INGRESE LA DISTANCIA EN KM:");
                    double distancia = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar el buffer

                    EnvioTerrestre t1 = new EnvioTerrestre(codigo, destino, peso, distancia);
                    lstEnvios.add(t1);
                    System.out.println("Envío terrestre registrado.");
                    break;
                }

                case 2: {
                    System.out.println("INGRESE EL CÓDIGO:");
                    String codigo = teclado.nextLine();

                    System.out.println("INGRESE EL DESTINO:");
                    String destino = teclado.nextLine();

                    System.out.println("INGRESE EL PESO EN KG:");
                    double peso = teclado.nextDouble();

                    System.out.println("INGRESE LA DISTANCIA EN KM:");
                    double distancia = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar el buffer

                    EnvioAereo a1 = new EnvioAereo(codigo, destino, peso, distancia);
                    lstEnvios.add(a1);
                    System.out.println("Envío aéreo registrado.");
                    break;
                }

                case 3: {
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        for (Envio e : lstEnvios) {
                            e.mostrarInformacion();
                            System.out.println("--------------------");
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("INGRESE EL CÓDIGO QUE DESEA BUSCAR:");
                    String codigoBuscado = teclado.nextLine();
                    boolean encontrado = false;

                    for (Envio e : lstEnvios) {
                        if (e.getcodigo().equalsIgnoreCase(codigoBuscado)) {
                            e.mostrarInformacion();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) { // Corregido: '!' para indicar que NO se encontró
                        System.out.println("No se encontró ese envío.");
                    }
                    break;
                }

                case 5: {
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        Envio masCostoso = lstEnvios.get(0);

                        for (Envio e : lstEnvios) {
                            if (e.calcularCosto() > masCostoso.calcularCosto()) {
                                masCostoso = e;
                            }
                        }

                        System.out.println("El envío más costoso es:");
                        masCostoso.mostrarInformacion();
                    }
                    break;
                }

                case 6: {
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        double total = 0;
                        for (Envio e : lstEnvios) {
                            total += e.calcularCosto();
                        }
                        System.out.println("Total recaudado: $" + total);
                    }
                    break;
                }

                case 7: {
                    int cantidadTerrestres = 0;
                    int cantidadAereos = 0;

                    for (Envio e : lstEnvios) {
                        if (e instanceof EnvioTerrestre) {
                            cantidadTerrestres++;
                        } else if (e instanceof EnvioAereo) {
                            cantidadAereos++;
                        }
                    }

                    System.out.println("Envíos terrestres: " + cantidadTerrestres);
                    System.out.println("Envíos aéreos: " + cantidadAereos);
                    break;
                }

                case 8:
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida. Ingrese un número del 1 al 8.");
            }
        } while (!salir);

        teclado.close();
    }
}