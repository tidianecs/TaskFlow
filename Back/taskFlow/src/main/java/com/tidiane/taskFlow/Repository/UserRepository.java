package com.tidiane.taskFlow.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidiane.taskFlow.Model.Project;
import com.tidiane.taskFlow.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String connectedUsername);
    
}
