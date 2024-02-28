package com.example.feb2024.controller;

import com.example.feb2024.service.CalculateRestService;
import com.example.feb2024.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    // CalculatorService calculatorService = new CalculatorService();

    //Dependency Injection
    @Autowired
    CalculatorService calculatorService;

    @Autowired
    CalculateRestService calculateRestService;

    @GetMapping("/divide/{first}/{second}")
    public ResponseEntity<Object> divide(@PathVariable("first") double first,
                                 @PathVariable("second") double second){
        if(second == 0){
            return new ResponseEntity<>("SECOND INPUT IS ZERO, DIVISION NOT APPLICABLE", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(calculatorService.divide(first, second), HttpStatus.OK);
    }

    @GetMapping("/add/{first}/{second}")
    public double add(@PathVariable("first") double first,
                      @PathVariable("second") double second){
        return calculateRestService.calculateAddtion(first, second);
    }
}
