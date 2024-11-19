package com.example.johnspetitions;
import com.example.johnspetitions.Petition;
import org.springframework.stereotype.Service;

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

} // end class
