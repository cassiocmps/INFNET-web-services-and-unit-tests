import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ex05_PostCreateEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities";
        String jsonInput = "{\"name\": \"aluno\"}";
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            HttpResponse response = HttpUtils.sendRequest(endpoint, "POST", jsonInput, headers);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
            // Try to extract the generated ID (usually 11)
            String resp = response.body;
            String id = null;
            int idIndex = resp.indexOf("\"id\":");
            if (idIndex != -1) {
                int start = idIndex + 5;
                int end = resp.indexOf(',', start);
                if (end == -1) end = resp.indexOf('}', start);
                if (end != -1) {
                    id = resp.substring(start, end).replaceAll("[^0-9]", "").trim();
                }
            }
            if (id != null) {
                System.out.println("Created entity ID: " + id);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
