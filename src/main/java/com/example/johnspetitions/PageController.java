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

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/johnspetitions/";
    }

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
            @RequestParam String oneLine,
            @RequestParam String description,
            @RequestParam String creatorName,
            @RequestParam(required = false) Boolean subscribeNewsletter
    ){
        Petition petition = new Petition(title, oneLine, description, creatorName, subscribeNewsletter);
        petitionService.addPetition(petition);
        return "redirect:/viewPetitions";
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
        if(!results.isEmpty()){
            Petition petition = results.get(0);
            return "redirect:/petition/" + petition.getId();
        }else{
            model.addAttribute("message","No petitions found for the search: "+keyword);
            return "searchPetitions";
        }
    }

    @GetMapping("/petition/{id}")
    public String viewPetition(@PathVariable String id, Model model){
        Petition petition = petitionService.getPetitionById(id);
        if(petition != null){
            model.addAttribute("petition", petition);
            return "petition";
        }else{
            model.addAttribute("message", "Petition not found.");
            return "error";
        }

    }

    @PostMapping("/petition/{id}")
    public String createPetitionSignature(
            @PathVariable String id,
            @RequestParam String name,
            @RequestParam String email,
            Model model
    ) {
        Petition petition = petitionService.getPetitionById(id);
        if(petition != null){
            model.addAttribute("petition", petition);
            model.addAttribute("message", "Thank you, " + name + ", for signing the petition!");
            return "petition"; // Stay on the same page
        } else {
            model.addAttribute("message", "Petition not found.");
            return "error"; // Or handle gracefully with an error page
        }
        }



} //end class
