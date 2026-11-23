import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Consumo da API Via Cep
// Aluno: Athos Nascimento Rego
// RA: 0025157


public class Cep {

    public static void main(String[] args) {
//Colocar o cep abaixo para dar o endereço completo
        String cep = "72405610";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println(response.body());

        } catch (Exception e) {
//Caso digite o cep errado ele dara erro ao consultar
            System.out.println("Erro ao consultar o CEP: " + e.getMessage());

        }
    }
}
