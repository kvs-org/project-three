package com.kvs.multiplication.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationServiceTest {

    private final MultiplicationService multiplicationService = new MultiplicationService();

    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(20, multiplicationService.multiply(4, 5));
    }

    @Test
    void testMultiplyNegativeNumbers() {
        assertEquals(20, multiplicationService.multiply(-4, -5));
    }

    @Test
    void testMultiplyPositiveAndNegativeNumbers() {
        assertEquals(-20, multiplicationService.multiply(4, -5));
    }

    @Test
    void testMultiplyWithZero() {
        assertEquals(0, multiplicationService.multiply(4, 0));
    }

}