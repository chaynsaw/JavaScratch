import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;

class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                URI.create("http://api.datamuse.com/words?sp=Im&md=s"))
                .header("accept", "application/json")
                .build();

        // use the client to send the request
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        JSONArray array = new JSONArray(response.body());
        JSONObject obj = array.getJSONObject(0);


    }

}