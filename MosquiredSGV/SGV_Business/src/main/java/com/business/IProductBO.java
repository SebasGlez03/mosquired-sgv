package com.business;

import java.util.List;

import com.dtos.ProductDTO;

public interface IProductBO {

  void addProduct(ProductDTO productDTO);

  void updateProduct(ProductDTO productDTO);

  void deleteProduct(Integer id);

  ProductDTO getProductById(Integer id);

  List<ProductDTO> getAllProducts();

  List<ProductDTO> searchProductsByName(String name);

  // Special method for Dasboard/BI
  List<ProductDTO> getProductsWithLowStock();

}
