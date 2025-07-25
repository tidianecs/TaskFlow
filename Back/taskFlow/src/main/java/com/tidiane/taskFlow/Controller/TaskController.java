package com.tidiane.taskFlow.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidiane.taskFlow.DTO.TaskDTO;
import com.tidiane.taskFlow.DTO.TaskResponseDTO;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Model.Task;
import com.tidiane.taskFlow.Repository.ProjectRepository;
import com.tidiane.taskFlow.Repository.TaskRepository;
import com.tidiane.taskFlow.Service.JwtService;
import com.tidiane.taskFlow.Service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired private TaskRepository taskRepository;
    @Autowired private TaskService taskService;
    @Autowired private JwtService jwtService;
    @Autowired private ProjectRepository projectRepository;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> addTask(@Valid @RequestBody TaskDTO task){
        TaskResponseDTO savedTask = taskService.createTaskFromDTO(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/all")
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id){
        return taskRepository.findById(id);
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<String> asDone(@PathVariable Long id){
        taskService.markTaskAsDone(id);
        return ResponseEntity.ok("Task marked as DONE.");
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTasksByProject(@PathVariable Long projectId) {
        String userId = jwtService.getConnectedUserId();
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new RuntimeException("Project not found"));
        
        if (!project.getOwner().getUserId().equals(userId)) {
            throw new RuntimeException("Access denied: not your project");
        }

        return taskRepository.findByAssignProject_ProjectId(projectId);
    }

}
