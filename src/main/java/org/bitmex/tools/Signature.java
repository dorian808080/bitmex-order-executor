package org.bitmex.tools;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URL;

public class Signature {

    public static String generate(String secret, String verb, String url, String expires, String data) {
        try {
            String path = new URL(url).getPath();

            if (url.contains("?")) {
                path += "?" + new URL(url).getQuery();
            }

            return encode(secret, verb + path + expires + data);
        } catch (Exception e) {
            return "";
        }
    }

    private static String encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return bytesToHex(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    private static String bytesToHex(byte[] bytes) {
        String result = "";
        for (final byte element : bytes)
        {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

}
