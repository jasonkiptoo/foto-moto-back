package com.example.fotomoto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/secured")
public class DemoController {


    @GetMapping

    public ResponseEntity<String> sayHi(){
        return  ResponseEntity.ok("Hiii");
    }

}
