package com.tidiane.taskFlow.DTO;
import java.time.LocalDateTime;
import com.tidiane.taskFlow.Model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class TaskResponseDTO {
    private Long taskId;
    @NotBlank private String content;
    @NotNull private TaskStatus status;
    @NotBlank private String projectName;
    @NotBlank private String userName;
    /*I will make NotNull for all the date*/
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    
    public TaskResponseDTO(Long taskId, String content, TaskStatus status, String projectName, String userName, LocalDateTime dueDate, LocalDateTime createdAt) {
        this.taskId = taskId;
        this.content = content;
        this.status = status;
        this.projectName = projectName;
        this.userName = userName;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAT(){
        return createdAt;
    }

    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public LocalDateTime getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }
}

