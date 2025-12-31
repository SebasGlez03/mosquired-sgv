package com.business;

import java.util.List;

import com.dtos.InventoryMovementDTO;

public interface IInventoryMovementBO {

  void registerMovement(InventoryMovementDTO movementDTO);

  List<InventoryMovementDTO> getAllMovements();

  List<InventoryMovementDTO> getMovementsByProduct(Integer productId);

  List<InventoryMovementDTO> getMovementsByRawMaterial(Integer materialId);

}
