package com.tidiane.taskFlow.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id @GeneratedValue private Long userId;
    private String userName;
    private String userEmail;

    //empty contructor for jpa
    public User(){}

    public User(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Long getUserId(){
        return userId;
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
