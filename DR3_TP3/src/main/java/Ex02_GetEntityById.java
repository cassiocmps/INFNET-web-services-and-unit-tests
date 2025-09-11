import java.io.IOException;
import java.util.Map;

public class Ex02_GetEntityById {
    public static void run() {
        for (int i = 1; i <= 8; i++) {
            getEntityById(i);
            System.out.println("-----------------------------");
        }
    }

    private static void getEntityById(int id) {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/" + id;
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("Entity ID: " + id);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
