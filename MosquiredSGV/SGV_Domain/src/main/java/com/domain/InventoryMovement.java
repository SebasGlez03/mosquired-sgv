/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import com.enumerators.MovementType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class of Inventory Movements
 * @author PC
 */
@Entity
@Table(name = "inventory_movements")
public class InventoryMovement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private Integer idMovement;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false)
    private MovementType movementType;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "id_material")
    private RawMaterial rawMaterial;
    
    @Column(nullable = false)
    private BigDecimal quantity;
    
    @Column(name = "date")
    private LocalDateTime date;
    
    private String note;
    
    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }

    public InventoryMovement() {
    }

    public InventoryMovement(MovementType movementType, Product product, RawMaterial rawMaterial, BigDecimal quantity, String note) {
        this.movementType = movementType;
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.note = note;
    }

    public Integer getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(Integer idMovement) {
        this.idMovement = idMovement;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
