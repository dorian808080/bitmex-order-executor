package org.bitmex.tools;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {
    public static String get(String url, Authentication authentication) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header(Authentication.API_EXPIRES, authentication.getExpires())
                .header(Authentication.API_KEY, authentication.getKey())
                .header(Authentication.API_SIGNATURE, authentication.getSignature())
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
