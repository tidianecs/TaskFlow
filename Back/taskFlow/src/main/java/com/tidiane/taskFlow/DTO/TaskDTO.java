package com.tidiane.taskFlow.DTO;
import java.time.LocalDate;

import com.tidiane.taskFlow.Model.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TaskDTO {
    @Id @GeneratedValue Long taskId;
    private String content;
    private TaskStatus status;
    private Long projectId;
    private Long userId;
    private LocalDate dueDate;
    private LocalDate createdAt = LocalDate.now();

    //Empty constructor for jpa
    public TaskDTO(){}

    public LocalDate getCreatedAT(){
        return createdAt;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public TaskStatus getStatus(){
        return status;
    }
    public void setStatus(TaskStatus status){
        this.status = status;
    }

    public Long getProjectId(){
        return projectId;
    }
    public void setProject(Long projectId){
        this.projectId = projectId;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
}
