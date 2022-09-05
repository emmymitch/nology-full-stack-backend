package com.example.mythologybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MythologyService {

    @Autowired
    MythologyRepository mythRepo;

    public List<Integer> extractIds() {
        List<Mythology> mythologyList = mythRepo.findAll();
        return mythologyList.stream()
                .map((mythology -> mythology.getId()))
                .collect(Collectors.toList());
    }

    //Add new
    public void addNewMythology(Mythology mythology) {
        if (mythology.getEnglishName() == null
            || mythology.getMajorDomains() == null
            || mythology.getDescription() == null){
            throw new IllegalArgumentException("Invalid submission! Must contain: English name, major domains, description.");
        }

        if (mythology.getDescription().length() > 255){
            throw new IllegalArgumentException("Description too long; 255 character max.");
        }

        mythRepo.save(mythology);
    }

    //Delete by id
    public boolean deleteById(String id){
        Mythology mythToDelete = getById(id);

        if (mythToDelete == null){
            return false;

        } else {
            mythRepo.delete(mythToDelete);
            return true;
        }
    }

    //Get All
    public List<Mythology> getAll() {
        return mythRepo.findAll();
    }

    //Get by id
    public Mythology getById(String id){
        return mythRepo.findById(Integer.parseInt(id)).orElse(null);
    }

    //Get by English name
    public List<Mythology> getByEnglishName(String englishName){
        return mythRepo.findMythologyByEnglishName(englishName);
    }

    //Get by Greek name
    public List<Mythology> getByGreekName(String greekName){
        return mythRepo.findMythologyByGreekName(greekName);
    }

    //Get by domain
    //Get by identifier

    //Get random
    public Mythology getRandomMythology() {
        List<Mythology> mythologyList = mythRepo.findAll();
        Random random = new Random();
        int randomIndex = random.nextInt(mythologyList.size());
        return mythologyList.get(randomIndex);
    }
}
