package org.bitmex.tools;

import org.junit.jupiter.api.Test;

import java.time.Instant;

class HttpTest {

    @Test
    void get() {
        String url = "https://testnet.bitmex.com/api/v1/order?count=100&reverse=false";
        String key = "###################";
        String secret = "#####################";
        String verb = "GET";
        String expires = Long.toString(Instant.now().getEpochSecond() + 5);
        String data = "";
        String signature = Signature.generate(secret, verb, url, expires, data);
        Authentication authentication = new Authentication(key, expires, signature);

        String content = Http.get(url, authentication);

        System.out.println(content);
    }
}