package com.stackroute.services;

import org.springframework.stereotype.Component;

public class User {
    private String userName;
    private String password;
    private DatabaseConnection databaseConnection;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName,String password){
        databaseConnection = new DatabaseConnection();
        this.userName = userName;
        this.password = password;
        databaseConnection.setData(userName,password);
    }

    public String getUserName() {
       return databaseConnection.getUserName(this.userName,this.password);
        //return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
