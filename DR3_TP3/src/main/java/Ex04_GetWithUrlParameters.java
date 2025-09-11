import java.io.IOException;
import java.util.Map;

public class Ex04_GetWithUrlParameters {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities?categoria=teste&limite=5";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("Final URL: " + endpoint);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
