package com.tidiane.taskFlow.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidiane.taskFlow.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner_UserId(String userId);
    Optional<Project> findByProjectId(Long projectId);
}
