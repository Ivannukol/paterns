/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.pojo;

import java.util.Map;

/**
 *
 * @author abrel
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Map<Integer, Integer> score;
    private Type type;

    public User() {
    }

    public User(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String userName, String firstName, String lastName, Type type) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<Integer, Integer> getScore() {
        return score;
    }

    public void setScore(Map<Integer, Integer> score) {
        this.score = score;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        STUDENT(0),
        TEACHER(1);

        private final int value;

        private Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
