package utils;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class APIUtils {
    public String postCallGetCookies(JSONObject payload, String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json, text/plain, */*");
            connection.setRequestProperty("usertimezone", "-330");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, List<String>> headers = connection.getHeaderFields();
                List<String> cookies = headers.get("Set-Cookie");
                if (cookies != null && !cookies.isEmpty()) {
                    // Assuming the cookie you want is the first one in the list
                    return cookies.get(0).split(";")[0]; // Get the cookie value without attributes
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
