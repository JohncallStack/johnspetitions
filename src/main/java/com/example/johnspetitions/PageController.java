package com.example.johnspetitions;

import com.example.johnspetitions.Petition;
import com.example.johnspetitions.PetitionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PetitionService petitionService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/createPetition")
    public String createPetition(){
        return "createPetition";
    }

    @PostMapping("/createPetition")
    public String createPetition(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String creatorName,
            @RequestParam(required = false) Boolean subscribeNewsletter
    ){
        Petition petition = new Petition(title, description, creatorName, subscribeNewsletter);
        petitionService.addPetition(petition);
        return "redirect:/view";
    }

    @GetMapping("/viewPetitions")
    public String viewPetitions(Model model) {
        List<Petition> petitions = petitionService.getAllPetitions();
        model.addAttribute("petitions", petitions);
        return "viewPetitions";
    }

    @GetMapping("/searchPetitions")
    public String searchPetitions(){
        return "searchPetitions";
    }

    @PostMapping("/searchPetitions")
    public String searchResults(@RequestParam String keyword, Model model){
        List<Petition> results = petitionService.searchPetitions(keyword);
        model.addAttribute("results", results);
        return "petition";
    }

} //end class
