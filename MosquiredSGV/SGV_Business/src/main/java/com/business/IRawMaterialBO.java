package com.business;

import java.util.List;

import com.dtos.RawMaterialDTO;

public interface IRawMaterialBO {

  void addRawMaterial(RawMaterialDTO materialDTO);

  void updateRawMaterial(RawMaterialDTO materialDTO);

  void deleteRawMaterial(Integer id);

  RawMaterialDTO getRawMaterialById(Integer id);

  List<RawMaterialDTO> getAllRawMaterial();

}
