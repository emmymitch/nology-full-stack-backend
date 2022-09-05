package com.example.mythologybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MythologyRepository extends JpaRepository<Mythology, Integer> {



}
