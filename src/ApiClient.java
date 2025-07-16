import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_KEY = "c548023349d7764dd3a3472e"; // <-- SUBSTITUA PELA SUA CHAVE!

    public String getExchangeRates(String baseCurrency) {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Falha na requisição: Código " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível conectar à API: " + e.getMessage());
        }
    }
}
