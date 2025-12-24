/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import com.enumerators.MovementType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class InventoryMovementDTO {
   
    private Integer idMovement;
    private MovementType movementType;

    // Product (could be null if the movement is for raw material)
    private Integer productId;
    private String productName;

    // RawMaterial (could be null if the movement is for product)
    private Integer materialId;
    private String materialName;

    private BigDecimal quantity;
    private LocalDateTime date;
    private String note;

    public InventoryMovementDTO() {
    }

    public InventoryMovementDTO(Integer idMovement, MovementType movementType, Integer productId, String productName, Integer materialId, String materialName, BigDecimal quantity, LocalDateTime date, String note) {
        this.idMovement = idMovement;
        this.movementType = movementType;
        this.productId = productId;
        this.productName = productName;
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

    public InventoryMovementDTO(MovementType movementType, Integer productId, String productName, Integer materialId, String materialName, BigDecimal quantity, LocalDateTime date, String note) {
        this.movementType = movementType;
        this.productId = productId;
        this.productName = productName;
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

    public Integer getIdMovement() {
        return idMovement;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }
    
    
}
