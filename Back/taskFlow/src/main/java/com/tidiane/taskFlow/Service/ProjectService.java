package com.tidiane.taskFlow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidiane.taskFlow.DTO.ProjectResponseDTO;
import com.tidiane.taskFlow.DTO.TaskResponseDTO;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Model.Task;
import com.tidiane.taskFlow.Model.User;
import com.tidiane.taskFlow.Repository.ProjectRepository;
import com.tidiane.taskFlow.Repository.UserRepository;

@Service
public class ProjectService {
        @Autowired private UserRepository userRepository;
        @Autowired private JwtService jwtService;
        @Autowired private ProjectRepository projectRepository;

        public ProjectResponseDTO createProject(ProjectResponseDTO project) {
        Long userId = jwtService.getConnectedUserId();
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Project projectSave = new Project();
        projectSave.setOwner(user);
        projectSave.setProjectName(project.getProjectName());
        projectSave.setProjectDesc(project.getProjectDesc());
        projectSave.setTasks(project.getTasks());

        Project saved = projectRepository.save(projectSave);

        return new ProjectResponseDTO(saved.getProjectId(), saved.getProjectName(), saved.getProjectDesc(), saved.getOwner().getUserName(), saved.getTasks());
    }

    public List<ProjectResponseDTO> getUserConnectedProjects(){
        Long userId = JwtService.getConnectedUserId();
        List<Project> projects = projectRepository.findByOwner_UserId(userId);

        return projects.stream().map(project -> new ProjectResponseDTO(
                project.getProjectId(),
                project.getProjectName(),
                project.getProjectDesc(),
                project.getOwner().getUserName(),
                project.getTasks()
        )).toList();
    }

}
