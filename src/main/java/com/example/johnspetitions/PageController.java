package com.example.johnspetitions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/createPetition")
    public String createPetition(){
        return "createPetition";
    }

    @GetMapping("/viewPetitions")
    public String viewPetitions(Model model) {
        model.addAttribute("petitions", List.of("Petition 1", "Petition 2", "Petition 3"));
        return "viewPetitions";
    }

    @GetMapping("/searchPetitions")
    public String searchPetitions(){
        return "searchPetitions";
    }

    @GetMapping("/petition/{id}")
    public String petition(@PathVariable("id") String id, Model model){
        model.addAttribute("petitionTitle", "Example Petition Title" + id);
        model.addAttribute("petitionDescription", "This is an example petition description."+ id);
        return "petition";
    }

}
