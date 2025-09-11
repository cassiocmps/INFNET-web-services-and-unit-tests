import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
    public static HttpResponse sendRequest(String endpoint, String method, String body, Map<String, String> headers) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (body != null && !body.isEmpty() && (method.equals("POST") || method.equals("PUT"))) {
            connection.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(body);
                wr.flush();
            }
        }
        int status = connection.getResponseCode();
        String responseBody = readResponse(connection, status);
        Map<String, String> responseHeaders = new HashMap<>();
        for (int i = 1; ; i++) {
            String headerKey = connection.getHeaderFieldKey(i);
            String headerValue = connection.getHeaderField(i);
            if (headerKey == null && headerValue == null) break;
            if (headerKey != null && headerValue != null) {
                responseHeaders.put(headerKey, headerValue);
            }
        }
        connection.disconnect();
        return new HttpResponse(status, responseBody, responseHeaders);
    }

    private static String readResponse(HttpURLConnection connection, int status) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                status >= 200 && status < 400 ? connection.getInputStream() : connection.getErrorStream()
        ));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }
        in.close();
        return content.toString();
    }
}
