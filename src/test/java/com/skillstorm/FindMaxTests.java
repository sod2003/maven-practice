package com.skillstorm;

import static com.skillstorm.ArrayHelpers.findMax;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindMaxTests {
    @Test
    void testMaxNull() {
        assertEquals(0, findMax(null));
    }

    @Test
    void findMaxEmpty() {
        assertEquals(0, findMax(new int[]{}));
    }

    @Test
    void findMaxOne() {
        assertEquals(1, findMax(new int[]{1}));
    }

    @Test
    void findMaxMultiple() {
        assertEquals(3, findMax(new int[]{1, 3, 2}));
    }

    @Test
    void findMaxNegatives() {
        assertEquals(3, findMax(new int[]{-1, 3, -2}));
    }

    @Test
    void findMaxAllNegative() {
        assertEquals(-1, findMax(new int[]{-1, -3, -2}));
    }
}
