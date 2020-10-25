package pak;

import com.squareup.okhttp.*;
import com.swagger.client.codegen.rest.invoker.ApiException;
import com.swagger.client.codegen.rest.invoker.auth.Authentication;
import com.swagger.client.codegen.rest.invoker.auth.HttpBasicAuth;
import com.swagger.client.codegen.rest.invoker.auth.OAuth;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

class AuthManager {

    private static final OAuth oAuth = new OAuth();
    private static final HttpBasicAuth httpBasicAuth = new HttpBasicAuth();
    private static String token;

    private static Request buildPostRequest() {
        String contentTypeHeader = "application/json";
        String acceptHeader = "application/json";
        String content = "{\n" +
                "    \"username\": \"%s\",\n" +
                "    \"password\": \"%s\"\n" +
                "}";
        String contentFormatted = String.format(content, ApiManager.getUser(), ApiManager.getPass());
        RequestBody requestBody = RequestBody
                .create(MediaType.parse(contentTypeHeader), contentFormatted);
        return new Request
                .Builder()
                .url(ApiManager.getApiUrl() + "/authenticate")
                .post(requestBody)
                .addHeader("Content-Type", contentTypeHeader)
                .addHeader("Accept", acceptHeader)
                .build();
    }

    private static JsonNode httpCall(Request request) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.body().bytes());
    }

    private static String generateToken() throws IOException {
        Request request =  buildPostRequest();
        JsonNode body = httpCall(request);
        return body.get("jwt").asText();
    }

    private static boolean isTokenValid(String token) throws IOException {
        String payload = token.split("\\.")[1];
        byte[] payloadBytes = Base64.getDecoder().decode(payload);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(payloadBytes);
        long exp = jsonNode.get("exp").asLong();
        return new Date(exp).after(new Date());
    }

    private static String getToken() throws IOException {
        if (token == null || !isTokenValid(token)) {
            token = generateToken();
        }
        return token;
    }

    public static Authentication generateAuthentication() throws ApiException {
        try {
            if (ApiManager.getAuthMethod() == AuthMethod.JWT) {
                oAuth.setAccessToken(getToken());
                return oAuth;
            }
            httpBasicAuth.setUsername(ApiManager.getUser());
            httpBasicAuth.setPassword(ApiManager.getPass());
            return httpBasicAuth;
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

}
