package com.skillstorm;

import static com.skillstorm.Main.getUserId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class Tests {
    
    @Test
    void returnValidIdTest() {
        assertEquals(12345, getUserId("https://www.skillstorm.store.com/user/12345"));
    }

    @Test
    void returnValidIdTest2() {
        assertEquals(12345, getUserId("https://www.skillstorm.store.com/user/12345/cart_id/5?checkout=false"));
    }

    // * @throws IllegalArgumentException if the url is null or empty
    @Test
    void assertThrowsIllegalArgumentTest(){
        assertThrows(IllegalArgumentException.class, () -> getUserId(null));
    }

    @Test
    void assertThrowsIllegalArgumentTest2(){
        assertThrows(IllegalArgumentException.class, () -> getUserId(""));
    }

    // * @throws NoSuchElementException if the string does not contain the term "user"
    @Test
    void assertThrowsNoSuchElementTest(){
        assertThrows(NoSuchElementException.class, () -> getUserId("https://www.skillstorm.store.com/"));
    }

    // * @throws NumberFormatException if the /user/ portion of the url is not followed by a valid number
    @Test
    void assertThrowsNumberFormatTest(){
        assertThrows(NumberFormatException.class, () -> getUserId("https://www.skillstorm.store.com/user/user5"));
    }
}
