import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Ex08_PutUpdateEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/10";
        String jsonInput = "{\"name\": \"atualizado\"}";
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            HttpResponse response = HttpUtils.sendRequest(endpoint, "PUT", jsonInput, headers);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
            // GET to verify update
            System.out.println("Verifying update with GET:");
            Ex08_PutUpdateEntity.getEntity();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void getEntity() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/10";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
