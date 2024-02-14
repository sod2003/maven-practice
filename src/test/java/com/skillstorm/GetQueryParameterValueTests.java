package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.skillstorm.Main.getQueryParameterValue;
import org.junit.jupiter.api.Test;

public class GetQueryParameterValueTests {
    @Test
    void getQueryParameterValueTest() {
        String urlCase1 = "https://www.domain.com/page?key1=value1&key2=value2";
        String urlCase2 = "https://www.domain.com/page?key1=value1&key2=";
        String urlCase3 = "https://www.domain.com/page";
        String urlCase4 = null;


        String keyCase1 = null;
        String keyCase2 = "";
        String keyCase3 = "key2";

        assertEquals("value2", getQueryParameterValue(urlCase1, keyCase2));
        assertEquals("", getQueryParameterValue(urlCase2, keyCase2));
        assertEquals(null, getQueryParameterValue(urlCase3, keyCase3));
        assertEquals(null, getQueryParameterValue(urlCase1, keyCase1));
        assertThrows(NullPointerException.class, () -> {getQueryParameterValue(urlCase4, keyCase2);});
    }

    @Test
    void nullURL() {
        assertThrows(NullPointerException.class, () -> {getQueryParameterValue(null, "any String");});
    }
}
