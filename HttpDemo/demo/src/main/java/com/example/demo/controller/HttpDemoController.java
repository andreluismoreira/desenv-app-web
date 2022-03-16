package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/httpDemo")
public class HttpDemoController {

    @GetMapping
    public String get(){
        return "Verbo Get Acionado";
    }

    @PostMapping
    public String post(){
        return "Verbo Post Acionado";
    }

    @DeleteMapping
    public String delete(){
        return "Verbo Delete Acionado";
    }

    @PutMapping
    public String put(){
        return "Verbo Put Acionado";
    }
}
