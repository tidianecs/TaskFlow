package com.tidiane.taskFlow.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tidiane.taskFlow.DTO.ProjectResponseDTO;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Model.User;
import com.tidiane.taskFlow.Repository.ProjectRepository;
import com.tidiane.taskFlow.Repository.UserRepository;

@Service
public class ProjectService {

    @Autowired private UserRepository userRepository;
    @Autowired private JwtService jwtService;
    @Autowired private ProjectRepository projectRepository;

    public ProjectResponseDTO createProject(ProjectResponseDTO projectDto) {
        String userId = jwtService.getConnectedUserId();
        System.out.println(userId);
        User user = userRepository.findById(userId).orElseGet(() -> {
                User newUser = new User();
                newUser.setUserId(userId);
                newUser.setUserName(jwtService.getConnectedUsername());
                newUser.setUserEmail("default@email.com");
                return userRepository.save(newUser);
            });


        Project project = new Project();
        project.setOwner(user);
        project.setProjectName(projectDto.getProjectName());
        project.setProjectDesc(projectDto.getProjectDesc());
        project.setCreatedAt(LocalDateTime.now());

        Project saved = projectRepository.save(project);

        return new ProjectResponseDTO(
                saved.getProjectId(),
                saved.getProjectName(),
                saved.getProjectDesc(),
                saved.getOwner().getUserName(),
                saved.getTasks()
        );
    }

    public List<ProjectResponseDTO> getUserConnectedProjects(String userId) {
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
