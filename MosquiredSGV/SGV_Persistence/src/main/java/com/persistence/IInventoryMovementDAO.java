/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.InventoryMovement;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IInventoryMovementDAO {
   
    void create(InventoryMovement movement);
    InventoryMovement find(Integer id);
    List<InventoryMovement> findAll();

    // History of movements from a specific product or material
    List<InventoryMovement> findByProduct(Integer productId);
    List<InventoryMovement> findByRawMaterial(Integer materialId);

}