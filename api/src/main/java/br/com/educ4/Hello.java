package br.com.educ4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Hello {

    @GetMapping
    public String get(){
        return  "Hello";
    }
}
