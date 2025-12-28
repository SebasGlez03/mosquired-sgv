/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.Product;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IProductDAO {

  void create(Product product);

  Product find(Integer id);

  List<Product> findAll();

  void update(Product product);

  void delete(Integer id);

  List<Product> findByName(String name);

  List<Product> findWithLowStock();
}
