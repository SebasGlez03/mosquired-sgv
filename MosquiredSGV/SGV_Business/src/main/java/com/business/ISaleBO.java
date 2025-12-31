package com.business;

import java.time.LocalDateTime;
import java.util.List;

import com.dtos.SaleDTO;

public interface ISaleBO {

  void createSale(SaleDTO saleDTO);

  SaleDTO getSaleById(Integer id);

  List<SaleDTO> getAllSales();

  List<SaleDTO> getSalesByDateRange(LocalDateTime start, LocalDateTime end);

  List<SaleDTO> getSalesByClient(Integer clientId);

}
