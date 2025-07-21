package com.tidiane.taskFlow.DTO;
import java.time.LocalDate;


public class TaskResponseDTO {
    private String content;
    private String status;
    private String projectName;
    private String userName;
    private LocalDate dueDate;
    private LocalDate createdAt = LocalDate.now();
    
    public TaskResponseDTO(String content, String status, String projectName, String userName, LocalDate dueDate, LocalDate createdAt) {
        this.content = content;
        this.status = status;
        this.projectName = projectName;
        this.userName = userName;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
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

    public String getProjectName(){
        return projectName;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
}

