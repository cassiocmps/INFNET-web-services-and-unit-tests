import java.io.IOException;
import java.util.Map;

public class Ex10_DeleteInvalidEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/2";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "DELETE", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
