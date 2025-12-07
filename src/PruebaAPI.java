public class PruebaAPI {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        String resultado = consulta.consultarMoneda("USD", "ARS");
        System.out.println(resultado);
    }
}