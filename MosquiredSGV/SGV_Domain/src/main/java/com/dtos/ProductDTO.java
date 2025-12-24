/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.math.BigDecimal;

/**
 *
 * @author PC
 */
public class ProductDTO {

    private Integer idProduct;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Integer currentStock;
    private Integer minimumStock;

    public ProductDTO() {
    }

    public ProductDTO(Integer idProduct, String name, String description, BigDecimal unitPrice, Integer currentStock, Integer minimumStock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    public ProductDTO(String name, String description, BigDecimal unitPrice, Integer currentStock, Integer minimumStock) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }
    
    

}
