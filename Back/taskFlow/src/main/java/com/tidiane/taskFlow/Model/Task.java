package com.tidiane.taskFlow.Model;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

    @Id @GeneratedValue private Long taskId;
    private String content;
    @Enumerated(EnumType.STRING) private TaskStatus status = TaskStatus.IN_GOING;
    @ManyToOne @JoinColumn(name = "projectId") private Project assignProject;
    @ManyToOne @JoinColumn(name = "userId") private User assignUser;
    private LocalDateTime dueDate;
    @CreationTimestamp private LocalDateTime createdAt;

    // Empty constructor for JPA
    public Task() {}

    public Task(String content, TaskStatus status, Project assignProject, User assignUser, LocalDateTime dueDate) {
        this.content = content;
        this.status = status;
        this.assignProject = assignProject;
        this.assignUser = assignUser;
        this.dueDate = dueDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public LocalDateTime getCreatedAT() {
        return createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return assignProject;
    }

    public void setProject(Project assignProject) {
        this.assignProject = assignProject;
    }

    public User getUser() {
        return assignUser;
    }

    public void setUser(User assignUser) {
        this.assignUser = assignUser;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
