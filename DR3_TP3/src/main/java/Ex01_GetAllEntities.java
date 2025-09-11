import java.io.IOException;

public class Ex01_GetAllEntities {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
