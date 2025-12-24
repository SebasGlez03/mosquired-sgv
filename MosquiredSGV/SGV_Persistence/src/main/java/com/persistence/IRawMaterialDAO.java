/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.RawMaterial;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IRawMaterialDAO {
   
    void create(RawMaterial rawMaterial);
    RawMaterial find(Integer id);
    List<RawMaterial> findAll();
    void update(RawMaterial rawMaterial);
    void delete(Integer id);

}
