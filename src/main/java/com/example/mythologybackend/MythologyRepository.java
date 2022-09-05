package com.example.mythologybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MythologyRepository extends JpaRepository<Mythology, Integer> {

    List<Mythology> findMythologyByEnglishName(String englishName);
    List<Mythology> findMythologyByGreekName(String greekName);

}
