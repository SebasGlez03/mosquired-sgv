package com.business.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.business.ISaleBO;
import com.domain.Client;
import com.domain.Product;
import com.domain.Sale;
import com.domain.SaleDetail;
import com.domain.User;
import com.dtos.SaleDTO;
import com.dtos.SaleDetailDTO;
import com.persistence.IClientDAO;
import com.persistence.IProductDAO;
import com.persistence.ISaleDAO;
import com.persistence.IUserDAO;
import com.persistence.impl.ClientDAO;
import com.persistence.impl.ProductDAO;
import com.persistence.impl.SaleDAO;
import com.persistence.impl.UserDAO;

public class SaleBO implements ISaleBO {

  private final ISaleDAO saleDAO = new SaleDAO();
  private final IUserDAO userDAO = new UserDAO();
  private final IClientDAO clientDAO = new ClientDAO();
  private final IProductDAO productDAO = new ProductDAO();

  /**
   * Creates a new sale into the database
   * 
   * @param saleDTO Info of the sale
   */
  @Override
  public void createSale(SaleDTO saleDTO) {
    // 1. Obtain father entities
    User user = userDAO.find(saleDTO.getUserId());
    Client client = clientDAO.find(saleDTO.getClientId());

    if (user == null || client == null) {
      throw new IllegalArgumentException("User or Client didn't exist.");
    }

    // 2. Create Sale Entity
    Sale sale = new Sale();
    sale.setUser(user);
    sale.setClient(client);
    sale.setTotalSale(saleDTO.getTotalSale());
    sale.setAmountPaid(saleDTO.getAmountPaid());
    sale.setPaymentStatus(saleDTO.getPaymentStatus());
    // Date appears automaticaly in PrePersist

    // 3. Process details and update stock
    List<SaleDetail> detailsEntity = new ArrayList<>();

    for (SaleDetailDTO detailDTO : saleDTO.getDetails()) {
      Product product = productDAO.find(detailDTO.getProductId());
      if (product != null) {
        // A. Create Detail
        SaleDetail detail = new SaleDetail(
            sale,
            product,
            detailDTO.getQuantity(),
            detailDTO.getUnitPrice(),
            detailDTO.getSubtotal());
        detailsEntity.add(detail);

        // B. Discount stock
        int newStock = product.getCurrentStock() - detailDTO.getQuantity();
        if (newStock < 0) {
          throw new IllegalStateException("Insufficient stock for:" + product.getName());
        }
        product.setCurrentStock(newStock);
        productDAO.update(product);
      }
    }

    sale.setDetails(detailsEntity);

    // 4. Save sale (Cascade will save the details)
    saleDAO.create(sale);
  }

  /**
   * Gets a list of all the sales from the database
   * 
   * @return List with all the sales
   */
  @Override
  public List<SaleDTO> getAllSales() {
    return mapListToDTO(saleDAO.findAll());
  }

  /**
   * Gets a sale from the database by its ID
   * 
   * @param id ID of the sale
   * @return A sale
   */
  @Override
  public SaleDTO getSaleById(Integer id) {
    Sale sale = saleDAO.find(id);
    return (sale != null) ? mapToDTO(sale) : null;
  }

  /**
   * Gets a list with sales from the database sorted by the client ID
   * 
   * @param clientId ID of the client
   * @return A list with the sales sorted by client id
   */
  @Override
  public List<SaleDTO> getSalesByClient(Integer clientId) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Gets a list with all the sales sorted by a date range
   * 
   * @param start Start of the date period
   * @param end   End of the date period
   * @return A list with all the sales sorted by the date period
   */
  @Override
  public List<SaleDTO> getSalesByDateRange(LocalDateTime start, LocalDateTime end) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Converts an Entity into a DTO
   * 
   * @param entity Entity to be converted into DTO
   * @return DTO object
   */
  private SaleDTO mapToDTO(Sale entity) {
    // Map details
    List<SaleDetailDTO> detailsDTO = new ArrayList<>();
    if (entity.getDetails() != null) {
      for (SaleDetail d : entity.getDetails()) {
        detailsDTO.add(new SaleDetailDTO(
            d.getIdDetail(),
            d.getProduct().getIdProduct(),
            d.getProduct().getName(),
            d.getQuantity(),
            d.getUnitPrice(),
            d.getSubtotal()));
      }
    }

    return new SaleDTO(
        entity.getIdSale(),
        entity.getClient().getIdClient(),
        entity.getClient().getName(),
        entity.getUser().getIdUser(),
        entity.getUser().getUsername(), // Or username, whatever I wantet to show
        entity.getSaleDate(),
        entity.getTotalSale(),
        entity.getAmountPaid(),
        entity.getPaymentStatus(),
        detailsDTO);
  }

  /**
   * Converts a list of entities into a list of DTOs
   * 
   * @param entities List of entities to ve converted into DTOs
   * @return List of DTOs
   */
  private List<SaleDTO> mapListToDTO(List<Sale> entities) {
    List<SaleDTO> dtos = new ArrayList<>();
    for (Sale s : entities) {
      dtos.add(mapToDTO(s));
    }
    return dtos;
  }

}
