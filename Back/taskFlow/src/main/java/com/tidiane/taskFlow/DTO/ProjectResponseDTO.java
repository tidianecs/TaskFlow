package com.tidiane.taskFlow.DTO;
import java.util.List;

import com.tidiane.taskFlow.Model.Task;

public class ProjectResponseDTO {
    private Long projectId;
    private String projectName;
    private String projectDesc;
    private String userName;
    private List<Task> tasks;


    public ProjectResponseDTO(Long projectId, String projectName, String projectDesc, String userName, List<Task> tasks) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.userName = userName;
        this.tasks = tasks;
    }

    // Getters et Setters
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
