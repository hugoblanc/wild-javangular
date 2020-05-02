package com.wildapi.api.services.battle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildapi.api.services.algo.Algo;
import com.wildapi.api.services.user.User;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Entity
public class Battle {

    @Id
    @GeneratedValue
    private Long id;

    public String name;

    public int level;

    @JsonBackReference
    @JoinColumn(name = "creator_id")
    @ManyToOne
    @CreatedBy
    private User creator;

    public Date launchDate;

    public Duration duration;

    @JsonManagedReference
    @OneToMany(mappedBy = "battle", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Algo> algoList;

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public List<Algo> getAlgoList() {
        return algoList;
    }

    public void setAlgoList(List<Algo> algoList) {
        this.algoList = algoList;
    }
}
