import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.json.JSONArray;

class App {
    private static final HttpClient client = HttpClient.newHttpClient();

    private static String filename = "my-poem.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        /*
         * Instructions for use:
         * 1. set private static variable filename to the path of your file (my-poem.txt is provided by default)
         * 2. Put the haiku in it
         * 3. run main()
         *
         * Tested with the following haikus (all true);
         *
         * Why am I so cold
         * Oh yeah, I have no jacket
         * So I deserve this
         *
         * Ive tried to tell you
         * Apple cider vinegar
         * It will change your life
         *
         * Hello World Im Here!
         * My first haiku in Java
         * More Programming. Yay!
         */
        Collection<String> lines = readPoem();
        System.out.println("Is " + filename + " a haiku? " + validateHaiku((ArrayList)lines));
    }

    public static HttpResponse<String> requestSyllableCount(String word) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder(
                URI.create("http://api.datamuse.com/words?sp=" + word + "&md=s"))
                .header("accept", "application/json")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static Integer getSyllables(String word) throws IOException, InterruptedException {
        var response = requestSyllableCount(word);
        JSONArray array = new JSONArray(response.body());
        JSONObject obj = array.getJSONObject(0);
        return Integer.parseInt(obj.get("numSyllables").toString());
    }

    private static boolean validateHaiku(ArrayList<String> potentialHaiku) throws IOException, InterruptedException {
        boolean isHaiku = true;
        if (potentialHaiku.size() != 3) {
            isHaiku = false;
        }
        if (findSyllablesInLine(potentialHaiku.get(0)) != 5 |
                findSyllablesInLine(potentialHaiku.get(1)) != 7 |
                findSyllablesInLine(potentialHaiku.get(2)) != 5
        ) {
            isHaiku = false;
        }


        return isHaiku;
    }

    private static int findSyllablesInLine(String line) throws IOException, InterruptedException {

        int total = 0;
        for (String word : line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")) {
            total += getSyllables(word);
        }
        return total;
    }

    private static ArrayList<String> readPoem() {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {  // TODO: initialize 'reader' variable
            String currentLine = null;
            while((currentLine =  reader.readLine()) != null) {
                result.add(currentLine);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}