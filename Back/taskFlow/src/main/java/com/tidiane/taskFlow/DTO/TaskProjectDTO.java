package com.tidiane.taskFlow.DTO;
import java.time.LocalDate;

public class TaskProjectDTO {
    private String content;
    private String status;
    private LocalDate dueDate;

    public TaskProjectDTO(String content, String status, LocalDate dueDate) {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
