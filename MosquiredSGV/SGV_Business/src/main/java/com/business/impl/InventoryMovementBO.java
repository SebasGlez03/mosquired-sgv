package com.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.business.IInventoryMovementBO;
import com.domain.InventoryMovement;
import com.domain.Product;
import com.domain.RawMaterial;
import com.dtos.InventoryMovementDTO;
import com.enumerators.MovementType;
import com.persistence.IInventoryMovementDAO;
import com.persistence.IProductDAO;
import com.persistence.IRawMaterialDAO;
import com.persistence.impl.InventoryMovementDAO;
import com.persistence.impl.ProductDAO;
import com.persistence.impl.RawMaterialDAO;

public class InventoryMovementBO implements IInventoryMovementBO {

  private final IInventoryMovementDAO movementDAO = new InventoryMovementDAO();
  private final IProductDAO productDAO = new ProductDAO();
  private final IRawMaterialDAO materialDAO = new RawMaterialDAO();

  /**
   * Gets a list with all the movements from the database
   * 
   * @return List with all the movements
   */
  @Override
  public List<InventoryMovementDTO> getAllMovements() {
    return mapListToDTO(movementDAO.findAll());
  }

  /**
   * Gets a list with all the movements from the database sorted by product
   * 
   * @param productId ID of the product to be sorted
   * @return List sorted by a product
   */
  @Override
  public List<InventoryMovementDTO> getMovementsByProduct(Integer productId) {
    return mapListToDTO(movementDAO.findByProduct(productId));
  }

  /**
   * Gets a list with all the movements from the databsae sorted by a material
   * 
   * @param materialId ID of the material to be sorted
   * @return List sorted by a material
   */
  @Override
  public List<InventoryMovementDTO> getMovementsByRawMaterial(Integer materialId) {
    return mapListToDTO(movementDAO.findByRawMaterial(materialId));
  }

  /**
   * Registers a new movement into the database
   * 
   * @param movementDTO Info of the movement
   */
  @Override
  public void registerMovement(InventoryMovementDTO movementDTO) {
    InventoryMovement movement = new InventoryMovement();
    movement.setMovementType(movementDTO.getMovementType());
    movement.setQuantity(movementDTO.getQuantity());
    movement.setNote(movementDTO.getNote());
    // The date sates itself in @PrePersist of the entity

    // Logic: Determine if it is Product or RawMaterial and Update stock
    if (movementDTO.getProductId() != null) {
      Product product = productDAO.find(movementDTO.getProductId());
      if (product != null) {
        movement.setProduct(product);
        updateProductStock(product, movementDTO.getMovementType(), movementDTO.getQuantity());
      }
    } else if (movementDTO.getMaterialId() != null) {
      RawMaterial material = materialDAO.find(movementDTO.getMaterialId());
      if (material != null) {
        movement.setRawMaterial(material);
        updateMaterialStock(material, movementDTO.getMovementType(), movementDTO.getQuantity());
      }
    }

    movementDAO.create(movement);
  }

  /**
   * Calculates the new stock of products
   * 
   * @param p    Product to be updated
   * @param type Type of the movement
   * @param qty  Quantity of product
   */
  private void updateProductStock(Product p, MovementType type, BigDecimal qty) {
    int quantityInt = qty.intValue(); // Assuming that products are integers

    if (type == MovementType.IN || type == MovementType.PRODUCTION) {
      p.setCurrentStock(p.getCurrentStock() + quantityInt);
    } else if (type == MovementType.OUT) {
      p.setCurrentStock(p.getCurrentStock() - quantityInt);
    }
    // Adjusts could sum or rest deppeding of the sign, here simplify
    productDAO.update(p);
  }

  /**
   * Calculates the new stock of raw materials
   * 
   * @param m    RawMaterial to be updated
   * @param type Type of the movement
   * @param qty  Quantity of product
   */
  private void updateMaterialStock(RawMaterial m, MovementType type, BigDecimal qty) {
    if (type == MovementType.IN) {
      m.setCurrentStock(m.getCurrentStock().add(qty));
    } else if (type == MovementType.OUT || type == MovementType.PRODUCTION) {
      // Production consume raw material (OUT)
      m.setCurrentStock(m.getCurrentStock().subtract(qty));
    }
    materialDAO.update(m);
  }

  /**
   * Convert a list of entities into a list of DTOs
   * 
   * @param entities List of entities
   * @result List of DTOs
   */
  private List<InventoryMovementDTO> mapListToDTO(List<InventoryMovement> entities) {
    List<InventoryMovementDTO> dtos = new ArrayList<>();
    for (InventoryMovement m : entities) {
      dtos.add(new InventoryMovementDTO(
          m.getIdMovement(),
          m.getMovementType(),
          (m.getProduct() != null) ? m.getProduct().getIdProduct() : null,
          (m.getProduct() != null) ? m.getProduct().getName() : null,
          (m.getRawMaterial() != null) ? m.getRawMaterial().getIdMaterial() : null,
          (m.getRawMaterial() != null) ? m.getRawMaterial().getName() : null,
          m.getQuantity(),
          m.getDate(),
          m.getNote()));
    }
    return dtos;
  }
}
