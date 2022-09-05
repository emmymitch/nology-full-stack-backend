package com.example.mythologybackend;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Mythology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String createdBy;
    private Timestamp datecreated;

    private String englishName;
    private String greekName;
    @ElementCollection
    private List<String> majorDomains;
    @ElementCollection
    private List<String> identifiers;
    private String description;

    public Mythology () {
        this.datecreated = new Timestamp(new Date().getTime());
    }

    public Mythology(int id, String createdBy, String englishName, String greekName, ArrayList<String> majorDomains, ArrayList<String> identifiers, String description) {
        this.id = id;
        this.createdBy = createdBy;
        this.datecreated = new Timestamp(new Date().getTime());

        this.englishName = englishName;
        this.greekName = greekName;
        this.majorDomains = majorDomains;
        this.identifiers = identifiers;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getGreekName() {
        return greekName;
    }

    public void setGreekName(String greekName) {
        this.greekName = greekName;
    }

    public List<String> getMajorDomains() {
        return majorDomains;
    }

    public void setMajorDomains(ArrayList<String> majorDomains) {
        this.majorDomains = majorDomains;
    }

    public List<String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(ArrayList<String> identifiers) {
        this.identifiers = identifiers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mythology{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", datecreated=" + datecreated +
                ", englishName='" + englishName + '\'' +
                ", greekName='" + greekName + '\'' +
                ", majorDomains=" + majorDomains +
                ", identifiers=" + identifiers +
                ", description='" + description + '\'' +
                '}';
    }
}
