package com.tidiane.taskFlow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidiane.taskFlow.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
