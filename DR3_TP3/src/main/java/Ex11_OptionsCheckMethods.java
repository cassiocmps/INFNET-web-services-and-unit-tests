import java.io.IOException;
import java.util.Map;

public class Ex11_OptionsCheckMethods {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "OPTIONS", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            String allow = response.headers.get("Allow");
            System.out.println("Allowed HTTP Methods: " + allow);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
