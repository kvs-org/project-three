package com.kvs.multiplication.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {

    public int multiply(int a, int b) {
        return a * b;
    }

}
