package com.example.johnspetitions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class PageController {

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/createPetition")
    public String createPetition(){
        return "createPetition";
    }

    @GetMapping("/viewPetitions")
    public String viewPetitions(){
        return "viewPetitions";
    }

    @GetMapping("/searchPetitions")
    public String searchPetitions(){
        return "searchPetitions";
    }

    @GetMapping("/petition")
    public String petition(){
        return "petition";
    }



}
