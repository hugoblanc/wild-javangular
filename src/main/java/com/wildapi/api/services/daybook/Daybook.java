package com.wildapi.api.services.daybook;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildapi.api.services.task.Task;
import com.wildapi.api.services.user.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Daybook {

    @Id
    @GeneratedValue
    private Long id;


    @CreatedDate
    private Date date;

    private String theme;


    @Column(columnDefinition = "boolean default false")
    private boolean validated;

    @Column(columnDefinition = "boolean default false")
    private boolean finished;


    @JsonBackReference(value = "creator-daybooks")
    @JoinColumn(name = "creator_id")
    @ManyToOne
    @CreatedBy
    private User creator;


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


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
