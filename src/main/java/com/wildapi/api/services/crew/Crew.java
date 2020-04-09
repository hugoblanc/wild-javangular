package com.wildapi.api.services.crew;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Crew {

    @Id()
    private Long id;
    private String name;
    private String description;
    private String created_at;
    private String updated_at;
    private String start_date;
    private boolean opened;


    // Getter Methods

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getStart_date() {
        return start_date;
    }

    public boolean getOpened() {
        return opened;
    }

    // Setter Methods

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
