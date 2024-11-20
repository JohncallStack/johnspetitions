package com.example.johnspetitions;
import com.example.johnspetitions.Petition;
import org.springframework.stereotype.Service;

//class to handle methods for petition object and therefore add functionality to website.
//Including adding petition objects to a list for View petitions page.
//A search function that utilises a stream to find searched keyword.
//A function to get a specific petition based on it's unique ID. Used to map to individual petition pages.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetitionService {

    private final List<Petition> petitions = new ArrayList<>();

    public void addPetition(Petition petition){
        petitions.add(petition);
    }

    public List<Petition> getAllPetitions(){
        return new ArrayList<>(petitions);
    }

    public List<Petition> searchPetitions(String keyword){
        return petitions.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Petition getPetitionById(String id){
        return petitions.stream()
                .filter(petition -> petition.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

} // end class
