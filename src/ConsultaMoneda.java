import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public String consultarMoneda(String monedaBase, String monedaDestino) {
        String apiKey = "e241ed94d1974810e744155a";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + monedaBase + "/" + monedaDestino;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
}
