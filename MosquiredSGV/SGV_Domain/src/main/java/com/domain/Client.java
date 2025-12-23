/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entity class of the Client
 *
 * @author PC
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    /**
     * Creates the default value of the "createdIn" value
     */
    protected void onCreate() {
        createdIn = LocalDateTime.now();
    }

    /**
     * Omission constructor
     */
    public Client() {
    }

    /**
     * Constructor that uses only the varibles that could change at creation
     * time
     *
     * @param name Name of the client
     * @param telephone Telephone of the client
     * @param address Address of the client
     * @param email Email of the client
     */
    public Client(String name, String telephone, String address, String email) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    /**
     * Gets the ID of the client
     *
     * @return ID of the client
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * Sets the ID of the client
     *
     * @param idClient ID of the client
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * Gets the name of the client
     *
     * @return Name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client
     *
     * @param name Name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the telephone of the client
     *
     * @return Telephone of the client
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the telephone of the client
     *
     * @param telephone Telephone of the client
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the address of the client
     *
     * @return Address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client
     *
     * @param address Address of the client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the email of the client
     *
     * @return Email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the client
     *
     * @param email Email of the client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the date when the client was created
     *
     * @return Date of client creation
     */
    public LocalDateTime getCreatedIn() {
        return createdIn;
    }

    /**
     * Sets the date when the client was creted
     *
     * @param createdIn Date of the client creation
     */
    public void setCreatedIn(LocalDateTime createdIn) {
        this.createdIn = createdIn;
    }

}
