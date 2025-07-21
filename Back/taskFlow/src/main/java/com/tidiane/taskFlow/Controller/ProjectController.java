package com.tidiane.taskFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Repository.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired private ProjectRepository projectRepository;

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @GetMapping("/all")
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProject(@PathVariable Long id){
        return projectRepository.findById(id);
    }
}
