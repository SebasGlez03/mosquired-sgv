/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import com.enumerators.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entity class of the User
 *
 * @author PC
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UserRole role;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    /**
     * Creates the default values of some variables (role and isActive)
     */
    // --- Life cicle of JPA ---
    @PrePersist
    protected void onCreate() {
        createdIn = LocalDateTime.now();

        // Default values at creation
        if (role == null) {
            role = UserRole.PERSONNEL;
        }
        if (isActive == null) {
            isActive = true; // By default, the user is active
        }
    }

    /**
     * Omission constructor
     */
    public User() {
    }

    /**
     * Constructor that uses only the varibles that could change at creation
     * time
     *
     * @param fullName Full name of the user
     * @param username Username
     * @param password Password of the user (should be hashed)
     * @param role Role of the user (PERSONNEL by default)
     */
    public User(String fullName, String username, String password, UserRole role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Gets the ID of the user
     *
     * @return ID of the user
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * Sets de ID of the user
     *
     * @param idUser ID of the user
     */
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets the full name of the user
     *
     * @return Full name of the user
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user
     *
     * @param fullName Full name of the user
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the username
     *
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user
     *
     * @return Password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     *
     * @param password Password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user
     *
     * @return Role of the user
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the role of the user
     *
     * @param role Role of the user
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets if the user is active
     *
     * @return User active or inactive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets if the user is active
     *
     * @param isActive User active or inactive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets the date when the user was created
     *
     * @return Date of user creation
     */
    public LocalDateTime getCreatedIn() {
        return createdIn;
    }

    /**
     * Sets the date when the user was created
     *
     * @param createdIn Date of user cretion
     */
    public void setCreatedIn(LocalDateTime createdIn) {
        this.createdIn = createdIn;
    }

}
