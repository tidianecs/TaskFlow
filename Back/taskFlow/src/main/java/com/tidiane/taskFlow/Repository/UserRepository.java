package com.tidiane.taskFlow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidiane.taskFlow.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
