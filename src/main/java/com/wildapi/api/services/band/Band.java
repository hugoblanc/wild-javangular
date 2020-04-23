package com.wildapi.api.services.band;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Band {

    @Id
    @GeneratedValue()
    private Long id;


    private String name;

    private int nbMembers;

    private String kind;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbMembers() {
        return nbMembers;
    }

    public void setNbMembers(int nbMembers) {
        this.nbMembers = nbMembers;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
