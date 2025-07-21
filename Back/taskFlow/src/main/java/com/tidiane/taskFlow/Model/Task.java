package com.tidiane.taskFlow.Model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
    @Id @GeneratedValue Long taskId;
    private String content;
    private String status;
    @ManyToOne @JoinColumn(name = "projectId") private Project assignProject;
    @ManyToOne @JoinColumn(name = "userId") private User assignUser;
    private LocalDate dueDate;
    private LocalDate createdAt = LocalDate.now();

    //Empty constructor for jpa
    public Task(){}

    public Task(String content, String status, Project assignProject, User assignUser, LocalDate duDate){
        this.content = content;
        this.status = status;
        this.assignProject = assignProject;
        this.assignUser = assignUser;
        this.dueDate = dueDate;
    }

    public LocalDate getCreatedAT(){
        return createdAt;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Project getProject(){
        return assignProject;
    }
    public void setProject(Project assignProject){
        this.assignProject = assignProject;
    }

    public User getUser(){
        return assignUser;
    }
    public void setUser(User assignUser){
        this.assignUser = assignUser;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
}
