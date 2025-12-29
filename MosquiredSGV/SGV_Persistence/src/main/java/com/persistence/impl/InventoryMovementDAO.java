package com.persistence.impl;

import java.util.List;

import com.domain.InventoryMovement;
import com.domain.util.JPAUtil;
import com.persistence.IInventoryMovementDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InventoryMovementDAO implements IInventoryMovementDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a new inventory movement into the database
   * 
   * @param movement Movement to be created
   */
  @Override
  public void create(InventoryMovement movement) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.persist(movement);
      tx.commit();
    } catch (Exception e) {
      if (tx.isActive())
        tx.rollback();
      throw e;
    } finally {
      em.close();
    }
  }

  /**
   * Finds an inventory movement via an id
   * 
   * @param id ID of the movement to be found
   */
  @Override
  public InventoryMovement find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(InventoryMovement.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list with all the inventory movements from the database
   */
  @Override
  public List<InventoryMovement> findAll() {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("SELECT m FROM InventoryMovement m ORDER BY m.date DESC", InventoryMovement.class)
          .getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list with all the inventory movements sorted by an id of a product
   * 
   * @param productId ID of the product to sort
   */
  @Override
  public List<InventoryMovement> findByProduct(Integer productId) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT m FROM InventoryMovement m WHERE m.product.idProduct = :pid ORDER BY m.date DESC";
      return em.createQuery(jpql, InventoryMovement.class).setParameter("pid", productId).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list with all the inventory movements sorted by an id of a material
   * 
   * @param materialId ID of the material to sort
   */
  @Override
  public List<InventoryMovement> findByRawMaterial(Integer materialId) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT m FROM InventoryMovement m WHERE m.rawMaterial.idMaterial = :mid ORDER BY m.date DESC";
      return em.createQuery(jpql, InventoryMovement.class).setParameter("mid", materialId).getResultList();
    } finally {
      em.close();
    }
  }

}
