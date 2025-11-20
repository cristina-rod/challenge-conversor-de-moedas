
import br.com.conversor.moedas.ConversaoMoeda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    public ConversaoMoeda buscarCotacao (String base_code, String target_code){

        String ApiKey = "c6fdfefb45e2291d0563f65c";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + ApiKey +"/pair/" + base_code + "/" + target_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversaoMoeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter a cotação!", e);
        }

    }

}
