import java.io.IOException;

public class Ex03_GetNonexistentEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/13";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            if (response.statusCode == 404) {
                System.out.println("Entity not found (404).\nResponse Body:\n" + response.body);
            } else {
                System.out.println("Response Body:\n" + response.body);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
