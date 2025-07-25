package com.tidiane.taskFlow.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id @Column(length = 36) private String userId;
    @NotBlank(message = "The user name is mandatory!") private String userName;
    @Email(message = "Put a correct email format!") private String userEmail;

    //empty contructor for jpa
    public User(){}

    public User(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserEmail(){
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
}
