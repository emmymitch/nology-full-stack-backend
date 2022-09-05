package com.example.mythologybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MythologyController {

    @Autowired
    MythologyService mythService;

    @PostMapping("/myth")
    public ResponseEntity<String> createMythology(@RequestBody Mythology mythology) {
        try {
            List<Mythology> existingMyths = mythService.getByEnglishName(mythology.getEnglishName());

            if (existingMyths.size() == 0){
                mythService.addNewMythology(mythology);
                return ResponseEntity.status(HttpStatus.OK).body("Myth saved successfully");
//
//            } else if (existingMyths.size() == 1){
//                mythService.updateMythology(existingMyths.get(0), mythology);
//                return ResponseEntity.status(HttpStatus.OK).body("Myth updated successfully");

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Multiple entries found: please delete incorrect/duplicate entries");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/myths")
    public ResponseEntity<List<Mythology>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mythService.getAll());
    }

    @GetMapping("/myth/{id}")
    public ResponseEntity<Mythology> getById(@PathVariable String id){
        Mythology myth = mythService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(myth);
    }

    @GetMapping("/myth")
    public ResponseEntity<List<Mythology>> getByEnglishName(@RequestParam String englishName){
        List<Mythology> myths = mythService.getByEnglishName(englishName);

        if (myths.size() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(myths);
    }


    @DeleteMapping("/myth/{id}")
    public ResponseEntity<String> deleteMyth(@PathVariable String id) {
        boolean isDeleted = mythService.deleteById(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry with id "+id+" not found!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Myth deleted successfully");
        }
    }

}
