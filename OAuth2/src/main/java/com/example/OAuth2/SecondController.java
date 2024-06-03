package com.example.OAuth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    MyComponent myComponent;

    public SecondController (MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    @GetMapping("/divide")
    public int divide (@RequestParam int a, @RequestParam int b) {

        return myComponent.divide(a,b);

    }

}
