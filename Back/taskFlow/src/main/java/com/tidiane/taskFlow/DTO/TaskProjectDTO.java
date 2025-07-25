package com.tidiane.taskFlow.DTO;
import java.time.LocalDateTime;

public class TaskProjectDTO {
    private String content;
    private String status;
    private LocalDateTime dueDate;

    public TaskProjectDTO(String content, String status, LocalDateTime dueDate) {
        this.content = content;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
