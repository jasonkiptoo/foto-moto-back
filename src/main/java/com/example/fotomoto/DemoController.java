package com.example.fotomoto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/demo")
public class DemoController {


    @GetMapping
    public ResponseEntity<String> HEllo(){
        return ResponseEntity.ok("helll");
    }

}
