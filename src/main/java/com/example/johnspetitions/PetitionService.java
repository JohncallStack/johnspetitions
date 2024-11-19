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

    public Petition getPetitionById(String id){
        return petitions.stream()
                .filter(petition -> petition.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addSignatureToPetition(String id, PetitionSignature petitionSignature) {
    }
} // end class
