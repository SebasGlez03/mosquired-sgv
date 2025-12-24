/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import com.enumerators.MeasurementUnit;
import java.math.BigDecimal;

/**
 *
 * @author PC
 */
public class RawMaterialDTO {

    private Integer idMaterial;
    private String name;
    private MeasurementUnit measurementUnit;
    private BigDecimal currentStock;

    public RawMaterialDTO() {
    }

    public RawMaterialDTO(Integer idMaterial, String name, MeasurementUnit measurementUnit, BigDecimal currentStock) {
        this.idMaterial = idMaterial;
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.currentStock = currentStock;
    }

    public RawMaterialDTO(String name, MeasurementUnit measurementUnit, BigDecimal currentStock) {
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.currentStock = currentStock;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public String getName() {
        return name;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public BigDecimal getCurrentStock() {
        return currentStock;
    }
    
    

}
