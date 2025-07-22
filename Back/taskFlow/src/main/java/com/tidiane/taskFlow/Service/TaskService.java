package com.tidiane.taskFlow.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tidiane.taskFlow.DTO.TaskDTO;
import com.tidiane.taskFlow.DTO.TaskResponseDTO;
import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Model.Task;
import com.tidiane.taskFlow.Model.User;
import com.tidiane.taskFlow.Repository.ProjectRepository;
import com.tidiane.taskFlow.Repository.TaskRepository;
import com.tidiane.taskFlow.Repository.UserRepository;

@Service
public class TaskService {
    @Autowired private UserRepository userRepository;
    @Autowired private ProjectRepository projectRepository;
    @Autowired private TaskRepository taskRepository;
    @Autowired private JwtService jwtService;

    public TaskResponseDTO createTaskFromDTO(TaskDTO taskDto){
        Project project = projectRepository.findById(taskDto.getProjectId())
                        .orElseThrow(() -> new RuntimeException("This project not found"));
        User user = userRepository.findByUserName(jwtService.getConnectedUsername())
                        .orElseThrow(() -> new RuntimeException("This user not found"));

        Task task = new Task();
        task.setContent(taskDto.getContent());
        task.setStatus(taskDto.getStatus());
        task.setProject(project);
        task.setUser(user);
        task.setDueDate(taskDto.getDueDate());

        Task saveTask = taskRepository.save(task);

        return new TaskResponseDTO(saveTask.getContent(), saveTask.getStatus(), project.getProjectName(), user.getUserName(), saveTask.getDueDate(), saveTask.getCreatedAT());
        
    }

    public List<TaskResponseDTO> getUserConnectedTasks(){
        String username = JwtService.getConnectedUsername();
        List<Task> tasks = taskRepository.findByUserName(username);

        return tasks.stream().map(task -> new TaskResponseDTO(
                task.getContent(),
                task.getStatus(),
                task.getProject().getProjectName(),
                task.getUser().getUserName(),
                task.getDueDate(),
                task.getCreatedAT()
        )).toList();
    }

}
