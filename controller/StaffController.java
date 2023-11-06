package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

//    This method handles the 'GET "/team"' request and
//    returns "Toby, Katerina, Sandy"
    @GetMapping("/team")
    public String index() {
        return "Toby, Katerina, Sandy";
    }
}
