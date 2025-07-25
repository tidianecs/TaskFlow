package com.tidiane.taskFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidiane.taskFlow.DTO.ProjectResponseDTO;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Repository.ProjectRepository;
import com.tidiane.taskFlow.Service.JwtService;
import com.tidiane.taskFlow.Service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired private ProjectRepository projectRepository;
    @Autowired private JwtService jwtService;
    @Autowired private ProjectService projectService;

    @PostMapping
    public ProjectResponseDTO addProject(@RequestBody ProjectResponseDTO projectDto) {
        return projectService.createProject(projectDto);
    }


    @GetMapping("/all")
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProject(@PathVariable Long id){
        return projectRepository.findByProjectId(id);
    }

    @GetMapping("/my-projects")
    public List<ProjectResponseDTO> getMyProjects() {
        String userId = JwtService.getConnectedUserId();
        return projectService.getUserConnectedProjects(userId);
    }

    @DeleteMapping("/{projectId}")
    public void delProject(@PathVariable Long projectId){
        projectRepository.deleteById(projectId);
    }
}
