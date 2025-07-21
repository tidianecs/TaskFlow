package com.tidiane.taskFlow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidiane.taskFlow.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
