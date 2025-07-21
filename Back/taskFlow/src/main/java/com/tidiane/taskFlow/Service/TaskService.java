package com.tidiane.taskFlow.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public TaskResponseDTO createTaskFromDTO(TaskDTO taskDto){
        Project project = projectRepository.findById(taskDto.getProjectId())
                        .orElseThrow(() -> new RuntimeException("This project not found"));
        User user = userRepository.findById(taskDto.getUserId())
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

}
