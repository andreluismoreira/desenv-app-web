package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value ="default-endpoints")
@RestController
@RequestMapping("/httpDemo")
public class HttpDemoController {

    @ApiOperation(value = "Get")
    @GetMapping
    public String get(){
        return "Verbo Get Acionado";
    }

    @ApiOperation(value = "Post")
    @PostMapping
    public String post(){
        return "Verbo Post Acionado";
    }

    @ApiOperation(value = "Delete")
    @DeleteMapping
    public String delete(){
        return "Verbo Delete Acionado";
    }

    @ApiOperation(value = "Put")
    @PutMapping
    public String put(){
        return "Verbo Put Acionado";
    }
}
