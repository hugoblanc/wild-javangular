package com.wildapi.api.services.daybook;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildapi.api.services.task.Task;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Daybook {

    @Id
    @GeneratedValue
    private Long id;


    private Date date;

    private String theme;

    private boolean validated;

    private boolean finished;

    @JsonManagedReference
    @OneToMany(mappedBy = "daybook", cascade = CascadeType.ALL)
    private List<Task> taskList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
