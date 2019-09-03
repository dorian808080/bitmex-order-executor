package org.bitmex.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignatureTest {

    @Test
    void generate_GetInstrument() {
        String secret = "chNOOS4KvNXR_Xq4k4c9qsfoKWvnDecLATCRlcBwyKDYnWgO";
        String verb = "GET";
        String url = "https://testnet.bitmex.com/api/v1/instrument";
        String expires = "1518064236";
        String data = "";

        assertEquals("c7682d435d0cfe87c16098df34ef2eb5a549d4c5a3c2b1f0f77b8af73423bf00", Signature.generate(secret, verb, url, expires, data));
    }

    @Test
    void generate_GetInstrumentWithFilter() {
        String secret = "chNOOS4KvNXR_Xq4k4c9qsfoKWvnDecLATCRlcBwyKDYnWgO";
        String verb = "GET";
        String url = "https://testnet.bitmex.com/api/v1/instrument?filter=%7B%22symbol%22%3A+%22XBTM15%22%7D";
        String expires = "1518064237";
        String data = "";

        assertEquals("e2f422547eecb5b3cb29ade2127e21b858b235b386bfa45e1c1756eb3383919f", Signature.generate(secret, verb, url, expires, data));
    }
}