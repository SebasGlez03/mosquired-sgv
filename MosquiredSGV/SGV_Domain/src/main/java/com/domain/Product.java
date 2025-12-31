/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Entity class of the Product
 *
 * @author PC
 */
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_product")
  private Integer idProduct;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
  private BigDecimal unitPrice;

  @Column(name = "current_stock")
  private Integer currentStock;

  @Column(name = "minimum_stock")
  private Integer minimumStock;

  /**
   * Omission constructor
   */
  public Product() {
  }

  /**
   * Constructor that initializes the variables of the class
   *
   * @param name         Name of the product
   * @param description  Description of the product
   * @param unitPrice    Unit price of the product
   * @param currentStock Current stock of the product
   * @param minimumStock Minimum stochk of the product
   */
  public Product(String name, String description, BigDecimal unitPrice, Integer currentStock, Integer minimumStock) {
    this.name = name;
    this.description = description;
    this.unitPrice = unitPrice;
    this.currentStock = currentStock;
    this.minimumStock = minimumStock;
  }

  /**
   * Gets the name of the product
   *
   * @return Name of the product
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the product
   *
   * @param name Name of the product
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the description of the product
   *
   * @return Description of the product
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the product
   *
   * @param description Description of the product
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the unit price of the product
   *
   * @return Unit price of the product
   */
  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  /**
   * Sets the unit price of the product
   *
   * @param unitPrice Unit price of the product
   */
  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  /**
   * Gets the current stock of the product
   *
   * @return Current stock of the product
   */
  public Integer getCurrentStock() {
    return currentStock;
  }

  /**
   * Sets the current stock of the product
   *
   * @param currentStock Current stock of the product
   */
  public void setCurrentStock(Integer currentStock) {
    this.currentStock = currentStock;
  }

  /**
   * Gets minimum stock for a product
   *
   * @return Minimum stock for a product
   */
  public Integer getMinimumStock() {
    return minimumStock;
  }

  /**
   * Sets minimum stock for a product
   *
   * @param minimumStock Minimum stock for a product
   */
  public void setMinimumStock(Integer minimumStock) {
    this.minimumStock = minimumStock;
  }

  public Integer getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Integer idProduct) {
    this.idProduct = idProduct;
  }

}
