package com.wildapi.api.services.user;

import com.wildapi.api.services.crew.Crew;

import javax.persistence.*;

@Entity
public class User {

    @Id()
    private Long id;

    private String email;

    private boolean admin;
    private String lastname;
    private String firstname;
    private String github;
    private boolean banished;
    private String fullname;
    private String main_role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_crew_id", referencedColumnName = "id")
    private Crew current_crew;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public boolean getAdmin() {
        return admin;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGithub() {
        return github;
    }

    public boolean getBanished() {
        return banished;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMain_role() {
        return main_role;
    }

    public Crew getCurrent_crew() {
        return current_crew;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public void setBanished(boolean banished) {
        this.banished = banished;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMain_role(String main_role) {
        this.main_role = main_role;
    }

    public void setCurrent_crew(Crew current_crew) {
        this.current_crew = current_crew;
    }


}