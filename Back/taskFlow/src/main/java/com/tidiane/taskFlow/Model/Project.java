package com.tidiane.taskFlow.Model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
    @Id @GeneratedValue private Long projectId;
    private String projectName;
    private String projectDesc;
    @OneToMany(mappedBy="assignProject", cascade = CascadeType.ALL) @JsonIgnore private List<Task> tasks; 
    private Long ownerId;
    private LocalDate createdAt = LocalDate.now();

    //empty constructor for jpa
    public Project(){}

    public Project(String projectName, String projectDesc, Long ownerId){
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.ownerId = ownerId;
    }

    public Long getProjectId(){
        return projectId;
    }
    public LocalDate getCreatedAT(){
        return createdAt;
    }

    public String getProjectName(){
        return projectName;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String getProjectDesc(){
        return projectDesc;
    }
    public void setProjectDesc(String projectDesc){
        this.projectDesc = projectDesc;
    }

    public List<Task> getTasks(){
        return tasks;
    }
    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    public Long getProjectOwnerId(){
        return ownerId;
    }
    public void setProjectOwnerId(Long ownerId){
        this.ownerId = ownerId;
    }
}
