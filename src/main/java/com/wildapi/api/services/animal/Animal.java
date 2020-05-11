package com.wildapi.api.services.animal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue()
    private Long id;

    private String imageUrl;

    private String scientific_name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getScientificName() {
        return scientific_name;
    }

    public void setScientificName(String scientificName) {
        this.scientific_name = scientificName;
    }
}
