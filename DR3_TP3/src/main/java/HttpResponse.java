import java.util.Map;

public class HttpResponse {
    public int statusCode;
    public String body;
    public Map<String, String> headers;

    public HttpResponse(int statusCode, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}

