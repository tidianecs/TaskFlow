package com.tidiane.taskFlow.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tidiane.taskFlow.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignUserUserName(String userName);
    List<Task> findByAssignProject_ProjectId(Long projectId);
}
