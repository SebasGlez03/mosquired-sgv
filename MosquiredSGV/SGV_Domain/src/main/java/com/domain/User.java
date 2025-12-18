/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import com.enumerators.UserRole;

/**
 *
 * @author PC
 */
public class User {

    int id;
    String name;
    String paternalSurname;
    String maternalSurname;
    String email;
    String password;
    boolean isActive;
    UserRole role;

    public User() {
    }

    public User(int id, String name, String paternalSurname, String maternalSurname, String email, String password, boolean isActive, UserRole role) {
        this.id = id;
        this.name = name;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public User(String name, String paternalSurname, String maternalSurname, String email, String password, boolean isActive, UserRole role) {
        this.name = name;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", paternalSurname=" + paternalSurname + ", maternalSurname=" + maternalSurname + ", email=" + email + ", password=" + password + ", isActive=" + isActive + ", role=" + role + '}';
    }

}
