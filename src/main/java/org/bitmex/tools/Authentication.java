package org.bitmex.tools;

public class Authentication {
    private String key;
    private String expires;
    private String signature;

    public static final String API_KEY = "api-key";
    public static final String API_EXPIRES = "api-expires";
    public static final String API_SIGNATURE = "api-signature";

    Authentication(String key, String expires, String signature) {
        this.key = key;
        this.expires = expires;
        this.signature = signature;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
