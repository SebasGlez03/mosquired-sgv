/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import com.enumerators.UserRole;

/**
 *
 * @author PC
 */
public class UserDTO {
   
    private Integer idUser;
    private String fullName;
    private String username;
    private UserRole role;
    private Boolean isActive;

    public UserDTO() {
    }

    public UserDTO(Integer idUser, String fullName, String username, UserRole role, Boolean isActive) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.username = username;
        this.role = role;
        this.isActive = isActive;
    }

    public UserDTO(String fullName, String username, UserRole role, Boolean isActive) {
        this.fullName = fullName;
        this.username = username;
        this.role = role;
        this.isActive = isActive;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    
    
    

}
