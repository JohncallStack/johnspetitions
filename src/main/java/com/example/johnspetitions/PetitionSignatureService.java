//package com.example.johnspetitions;
//
//import org.springframework.stereotype.Service;
//
//public class PetitionSignatureService {
//    private final PetitionService petitionService;
//
//    public PetitionSignatureService(PetitionService petitionService){
//        this.petitionService = petitionService;
//    }
//
//    public boolean addSignatureToPetition(String petitionId, PetitionSignature petitionSignature){
//        Petition petition = petitionService.getPetitionById(petitionId);
//        if(petition != null){
//            petition.getSignatures().add(signature);
//            return true;
//        }
//        return false;
//    }
//}
