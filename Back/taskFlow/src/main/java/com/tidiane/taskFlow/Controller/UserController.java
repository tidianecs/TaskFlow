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
import com.tidiane.taskFlow.Model.User;
import com.tidiane.taskFlow.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired private UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userRepository.findById(id);
    }
}
