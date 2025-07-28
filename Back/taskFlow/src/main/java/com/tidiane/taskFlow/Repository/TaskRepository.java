package com.tidiane.taskFlow.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tidiane.taskFlow.Model.Task;
import com.tidiane.taskFlow.Model.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignUserUserName(String userId);
    List<Task> findByAssignProject_ProjectId(Long projectId);
    List<Task> findByAssignUser_UserIdAndStatusAndDueDateBetween(String userId, TaskStatus status, LocalDateTime startOfDay, LocalDateTime endOfDay);
}
