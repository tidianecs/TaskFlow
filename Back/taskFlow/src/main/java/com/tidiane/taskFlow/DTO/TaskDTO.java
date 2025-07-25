package com.tidiane.taskFlow.DTO;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.tidiane.taskFlow.Model.TaskStatus;

public class TaskDTO implements Serializable{
    private String content;
    private TaskStatus status;
    private Long projectId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;

    //Empty constructor for jpa
    public TaskDTO(){}

    public LocalDateTime getCreatedAT(){
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
    public void setProjectId(Long projectId){
        this.projectId = projectId;
    }


    public LocalDateTime getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }
}
