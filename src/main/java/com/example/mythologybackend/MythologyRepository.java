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


//    @Modifying
//    @Query("UPDATE Mythology m SET m.englishName = :englishName WHERE m.id = :id")
//    void updateEnglishName(String englishName, int id);
//
//    @Modifying
//    @Query("UPDATE Mythology m SET m.greekName = :greekName WHERE m.id = :id")
//    void updateGreekName(String greekName, int id);


}
