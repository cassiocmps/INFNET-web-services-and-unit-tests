import java.io.IOException;

public class Ex06_GetCreatedEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/11";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
