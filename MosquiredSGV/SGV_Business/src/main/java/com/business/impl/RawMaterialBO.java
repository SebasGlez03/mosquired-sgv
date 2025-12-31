package com.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.business.IRawMaterialBO;
import com.domain.RawMaterial;
import com.dtos.RawMaterialDTO;
import com.persistence.IRawMaterialDAO;
import com.persistence.impl.RawMaterialDAO;

public class RawMaterialBO implements IRawMaterialBO {

  private final IRawMaterialDAO rawMaterialDAO = new RawMaterialDAO();

  /**
   * Aads a new material into the database
   * 
   * @param materialDTO Info of the material
   */
  @Override
  public void addRawMaterial(RawMaterialDTO materialDTO) {
    // DTO -> Entity
    RawMaterial material = new RawMaterial(
        materialDTO.getName(),
        materialDTO.getMeasurementUnit(),
        materialDTO.getCurrentStock());
    rawMaterialDAO.create(material);
  }

  /**
   * Deletes an existing material from the database
   */
  @Override
  public void deleteRawMaterial(Integer id) {
    rawMaterialDAO.delete(id);
  }

  /**
   * Gets a list of all the materials from the database
   * 
   * @return List of all the materials
   */
  @Override
  public List<RawMaterialDTO> getAllRawMaterial() {
    List<RawMaterial> list = rawMaterialDAO.findAll();
    List<RawMaterialDTO> dtos = new ArrayList<>();
    for (RawMaterial rm : list) {
      dtos.add(mapToDTO(rm));
    }
    return dtos;
  }

  /**
   * Gets a material from the database by its id
   * 
   * @param id ID of the material
   * @return A material from the database
   */
  @Override
  public RawMaterialDTO getRawMaterialById(Integer id) {
    RawMaterial material = rawMaterialDAO.find(id);
    return (material != null) ? mapToDTO(material) : null;
  }

  /**
   * Updates a material fom the database
   * 
   * @param materialDTO Info of the material to be updated
   */
  @Override
  public void updateRawMaterial(RawMaterialDTO materialDTO) {
    RawMaterial material = rawMaterialDAO.find(materialDTO.getIdMaterial());
    if (material != null) {
      material.setName(materialDTO.getName());
      material.setMeasurementUnit(materialDTO.getMeasurementUnit());
      material.setCurrentStock(materialDTO.getCurrentStock());

      rawMaterialDAO.update(material);
    }
  }

  /**
   * Covert a entity into a DTO object
   * 
   * @param entity Entity to be converted to DTO
   * @return DTO converted from the entity
   */
  private RawMaterialDTO mapToDTO(RawMaterial entity) {
    return new RawMaterialDTO(
        entity.getIdMaterial(),
        entity.getName(),
        entity.getMeasurementUnit(),
        entity.getCurrentStock());
  }

}
