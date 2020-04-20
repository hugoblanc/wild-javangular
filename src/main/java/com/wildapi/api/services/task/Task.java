package com.wildapi.api.services.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildapi.api.services.daybook.Daybook;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue()
    private Long id;

    private String title;

    private int importance;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daybook_id")
    private Daybook daybook;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
