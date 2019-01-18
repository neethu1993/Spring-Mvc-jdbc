package com.stackroute.services;

import java.sql.*;

public class DatabaseConnection {
    private Connection con;
    private String result;

    public String getUserName(String username,String password) {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1", "neethu", "root123");
            //create statement object
            System.out.println("got connected");

            Statement stmt = con.createStatement();


            //execute query
            ResultSet rs = stmt.executeQuery("select userName from user where password='"+password+"' and userName='"+username+"'");
            //process result
            while (rs.next()) {
                System.out.println(rs.getString(1));
                result = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public void setData(String username,String password){
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1", "neethu", "root123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement preparedStmt = con.prepareStatement("insert into user(userName,password) values(?,?)");
            preparedStmt.setString (1, username);
            preparedStmt.setString (2, password);
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
