package com.example.OAuth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String logout () {

        return "logout";
    }

    @GetMapping("/loggedin")
    public String loggedIn () {
        return "loggedIn";
    }

}
