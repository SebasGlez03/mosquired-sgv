/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.Client;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IClientDAO {
   
    void create(Client client);
    Client find(Integer id);
    List<Client> findAll();
    void update(Client client);
    void delete(Integer id);

}
