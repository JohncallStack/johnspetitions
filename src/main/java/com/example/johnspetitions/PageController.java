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

    //Inject Petitionservice class into controller to create functional methods.
    @Autowired
    private PetitionService petitionService;

    //GetMapping used to map through different paging on app.
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/createPetition")
    public String createPetition(){
        return "createPetition";
    }

    //PostMapping to take input, process it and map to a page with results.
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

    //Here we generate a list of petitions, collated from both the dummy dated and anything created by user.
    //getAllPetitions() Method is taken from injected petitionService.
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

    //Logic to redirect to search result page on entering a keyword present in the petition.
    //Method to undertake search is taken from petitionService. Also a response if result is no results found.
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

    //Mapping to the specific petition page using a unique id generated in a method in petitionService.
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

    //Method to deal with signature of petition and display a message to say it has been done sucessfully.
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
            model.addAttribute("message", "Thank you, " + name + ", for signing the petition: "
                    + petition.getTitle() + ". Please consider sharing on social media! ");
            return "petition";
        } else {
            model.addAttribute("message", "Petition not found.");
            return "error";
        }
        }

} //end class
