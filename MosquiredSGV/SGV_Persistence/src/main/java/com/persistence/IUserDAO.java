/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IUserDAO {

  void create(User user);

  User find(Integer id);

  List<User> findAll();

  void update(User user);

  void delete(Integer id);

  // Specific methods: login
  User login(String username, String password);

  User findByUsername(String username);

}
