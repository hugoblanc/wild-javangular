package com.wildapi.api.services.oauth.dto;

public class OdysseyUserDto {
    private float id;
    private String email;
    private boolean admin;
    private String lastname;
    private String firstname;
    private String github;
    private boolean banished;
    private String fullname;
    private String main_role;
    private OdysseyCrewDto current_crew;


    // Getter Methods

    public float getId() {
        return id;
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

    public OdysseyCrewDto getCurrent_crew() {
        return current_crew;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
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

    public void setCurrent_crew(OdysseyCrewDto current_crewObject) {
        this.current_crew = current_crewObject;
    }
}
