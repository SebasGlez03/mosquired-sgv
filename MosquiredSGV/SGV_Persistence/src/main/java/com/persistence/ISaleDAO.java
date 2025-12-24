/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.persistence;

import com.domain.Sale;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ISaleDAO {
   
    void create(Sale sale);
    Sale find(Integer id);
    List<Sale> findAll();

    // Reports
    List<Sale> findByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    List<Sale> findByClient(Integer clientId);
}
