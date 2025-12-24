/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

/**
 *
 * @author PC
 */
public class ClientDTO {
   
    private Integer idClient;
    private String name;
    private String telephone;
    private String address;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Integer idClient, String name, String telephone, String address, String email) {
        this.idClient = idClient;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    public ClientDTO(String name, String telephone, String address, String email) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    
    
    

}
