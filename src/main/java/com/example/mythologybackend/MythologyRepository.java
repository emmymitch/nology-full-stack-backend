package com.example.mythologybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MythologyRepository extends JpaRepository<Mythology, Integer> {

    List<Mythology> findMythologyByEnglishName(String englishName);
    List<Mythology> findMythologyByGreekName(String greekName);
    List<Mythology> findMythologyByMajorDomains(String domain);
    List<Mythology> findMythologyByIdentifiers(String identifier);

}
