package com.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.business.IProductBO;
import com.domain.Product;
import com.dtos.ProductDTO;
import com.persistence.IProductDAO;
import com.persistence.impl.ProductDAO;

public class ProductBO implements IProductBO {

  private final IProductDAO productDAO = new ProductDAO();

  /**
   * Adds a product into the database
   * 
   * @productDTO Info of the product
   */
  @Override
  public void addProduct(ProductDTO productDTO) {
    // DTO -> Entity
    Product product = new Product(
        productDTO.getName(),
        productDTO.getDescription(),
        productDTO.getUnitPrice(),
        productDTO.getCurrentStock(),
        productDTO.getMinimumStock());
    productDAO.create(product);
  }

  /**
   * Deletes a product from the database
   * 
   * @param id ID of the user to be deleted
   */
  @Override
  public void deleteProduct(Integer id) {
    productDAO.delete(id);
  }

  /**
   * Gets a list of all the products from the database
   */
  @Override
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productDAO.findAll();
    return mapListToDTO(products);
  }

  /**
   * Gets a product from the databsae by its id
   * 
   * @param id ID of the product to obtain
   */
  @Override
  public ProductDTO getProductById(Integer id) {
    Product product = productDAO.find(id);
    return (product != null) ? mapToDTO(product) : null;
  }

  /**
   * Gets a list of all the products with low stock from the database
   */
  @Override
  public List<ProductDTO> getProductsWithLowStock() {
    List<Product> lowStock = productDAO.findWithLowStock();
    return mapListToDTO(lowStock);
  }

  /**
   * Gets a list of products of all the products sorted by a name
   * 
   * @param name Name of the sorted product
   * @return A list of products sorted by name
   */
  @Override
  public List<ProductDTO> searchProductsByName(String name) {
    List<Product> products = productDAO.findByName(name);
    return mapListToDTO(products);
  }

  /**
   * Updates a product from the database
   * 
   * @param productDTO Info of the product to be updated
   */
  @Override
  public void updateProduct(ProductDTO productDTO) {
    Product product = productDAO.find(productDTO.getIdProduct());

    if (product != null) {
      product.setName(productDTO.getName());
      product.setDescription(productDTO.getDescription());
      product.setUnitPrice(productDTO.getUnitPrice());
      product.setCurrentStock(productDTO.getCurrentStock());
      product.setMinimumStock(productDTO.getMinimumStock());

      productDAO.update(product);
    }
  }

  /**
   * Converts an Entity into a DTO object
   * 
   * @param entity Objet entity to be converted to DTO
   * @return DTO object
   */
  private ProductDTO mapToDTO(Product entity) {
    return new ProductDTO(
        entity.getIdProduct(),
        entity.getName(),
        entity.getDescription(),
        entity.getUnitPrice(),
        entity.getCurrentStock(),
        entity.getMinimumStock());
  }

  /**
   * Converts a list of entities into a list of DTO objects
   * 
   * @param entities List of entities to be converted into DTO
   * @return List of DTO objects
   */
  private List<ProductDTO> mapListToDTO(List<Product> entities) {
    List<ProductDTO> dtos = new ArrayList<>();
    for (Product p : entities) {
      dtos.add(mapToDTO(p));
    }
    return dtos;
  }
}
