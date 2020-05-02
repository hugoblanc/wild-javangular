package com.wildapi.api.services.algo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildapi.api.services.battle.Battle;
import com.wildapi.api.services.solution.Solution;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Algo {

    @Id()
    @GeneratedValue()
    private Long id;

    private String title;


    private String solution;

    private String instructions;

    private boolean validated;

    private int level;

    private String skeleton;

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date modifyDate;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "battle_id")
    private Battle battle;

    @JsonManagedReference
    @OneToMany(mappedBy = "algo", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Solution> solutionList;


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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isValidated() {
        return validated;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkeleton() {
        return skeleton;
    }

    public void setSkeleton(String skeleton) {
        this.skeleton = skeleton;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }
}