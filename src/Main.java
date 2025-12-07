import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n*** Bienvenido al Conversor de Monedas ***");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                if (opcion >= 1 && opcion <= 6) {
                    System.out.print("Ingrese el valor que desea convertir: ");
                    double valor = Double.parseDouble(teclado.nextLine());

                    String monedaBase = "";
                    String monedaDestino = "";
                    String nombreBase = "";
                    String nombreDestino = "";

                    switch (opcion) {
                        case 1:
                            monedaBase = "USD";
                            monedaDestino = "ARS";
                            nombreBase = "dólares";
                            nombreDestino = "pesos argentinos";
                            break;
                        case 2:
                            monedaBase = "ARS";
                            monedaDestino = "USD";
                            nombreBase = "pesos argentinos";
                            nombreDestino = "dólares";
                            break;
                        case 3:
                            monedaBase = "USD";
                            monedaDestino = "BRL";
                            nombreBase = "dólares";
                            nombreDestino = "reales brasileños";
                            break;
                        case 4:
                            monedaBase = "BRL";
                            monedaDestino = "USD";
                            nombreBase = "reales brasileños";
                            nombreDestino = "dólares";
                            break;
                        case 5:
                            monedaBase = "USD";
                            monedaDestino = "COP";
                            nombreBase = "dólares";
                            nombreDestino = "pesos colombianos";
                            break;
                        case 6:
                            monedaBase = "COP";
                            monedaDestino = "USD";
                            nombreBase = "pesos colombianos";
                            nombreDestino = "dólares";
                            break;
                    }

                    String json = consulta.consultarMoneda(monedaBase, monedaDestino);
                    Moneda moneda = new Moneda(json);
                    double resultado = moneda.convertir(valor);

                    System.out.printf("\nEl valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]\n",
                            valor, nombreBase, resultado, nombreDestino);

                } else if (opcion == 7) {
                    System.out.println("\n¡Gracias por usar el conversor!");
                } else {
                    System.out.println("\nOpción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor ingrese un número válido.");
            }
        }

        teclado.close();
    }
}
