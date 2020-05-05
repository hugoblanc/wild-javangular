package com.wildapi.api.services.task;

public class TaskPutDTO {

    private Long id;
    private String title;
    private int importance;
    private boolean taskChecked;

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

    public boolean isTaskChecked() {
        return taskChecked;
    }

    public void setTaskChecked(boolean taskChecked) {
        this.taskChecked = taskChecked;
    }
}
