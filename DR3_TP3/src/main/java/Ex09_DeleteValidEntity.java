import java.io.IOException;

public class Ex09_DeleteValidEntity {
    public static void run() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/9";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "DELETE", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
            // Try to GET the deleted entity
            System.out.println("Trying to GET the deleted entity:");
            Ex09_DeleteValidEntity.getEntity();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void getEntity() {
        String endpoint = "https://apichallenges.eviltester.com/sim/entities/9";
        try {
            HttpResponse response = HttpUtils.sendRequest(endpoint, "GET", null, null);
            System.out.println("HTTP Status Code: " + response.statusCode);
            System.out.println("Response Body:\n" + response.body);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
