package com.kvs.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kvs.multiplication.service.MultiplicationService;

@RestController
public class MultiplicationController {

    @Autowired
    private MultiplicationService multiplyService;

    @GetMapping(path = {"/multiply"})
    public ResponseEntity<Integer> multiplication(@RequestParam int a, @RequestParam int b) {
        int result = multiplyService.multiply(a, b);
        return ResponseEntity.ok(result);
    }

}
