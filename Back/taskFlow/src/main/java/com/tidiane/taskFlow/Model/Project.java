package com.tidiane.taskFlow.Model;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"tasks"})
public class Project {
    @Id @GeneratedValue private Long projectId;
    private String projectName;
    private String projectDesc;
    @OneToMany(mappedBy="assignProject", cascade = CascadeType.ALL) private List<Task> tasks; 
    @ManyToOne @JoinColumn(name = "owner_id") private User owner;
    private LocalDateTime createdAt;

    //empty constructor for jpa
    public Project(){}

    public Project(String projectName, String projectDesc){
        this.projectName = projectName;
        this.projectDesc = projectDesc;
    }

    public Long getProjectId(){
        return projectId;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public LocalDateTime getCreatedAT(){
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

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

}
