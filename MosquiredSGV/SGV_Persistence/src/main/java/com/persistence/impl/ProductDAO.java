package com.persistence.impl;

import java.util.List;

import com.domain.Product;
import com.domain.util.JPAUtil;
import com.persistence.IProductDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductDAO implements IProductDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a product in the database
   * 
   * @param product Product to add in the database
   */
  @Override
  public void create(Product product) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.persist(product);
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
   * Deletes a product from the database via an id
   * 
   * @param id ID of the product to delete
   */
  @Override
  public void delete(Integer id) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      Product product = em.find(Product.class, id);
      if (product != null) {
        em.remove(product);
      }
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
   * Finds a product in the database
   *
   * @param id ID of the product
   */
  @Override
  public Product find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Product.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds all the list of products from the database
   */
  @Override
  public List<Product> findAll() {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Updates a product from the database
   * 
   * @param product Product to update
   */
  @Override
  public void update(Product product) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.merge(product);
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
   * Finds a list of products from the database by name
   * 
   * @param name Name of the product
   */
  @Override
  public List<Product> findByName(String name) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT p FROM Product p WHERE p.name LIKE :name";
      return em.createQuery(jpql, Product.class).setParameter("name", "%" + name + "%").getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Finds all the list of products with low stock
   */
  @Override
  public List<Product> findWithLowStock() {
    EntityManager em = getEntityManager();
    try {
      // Search for products where the current stock is less or equals to the minimum
      String jpql = "SELECT p FROM Product p WHERE p.currentStock <= p.minimumStock";
      return em.createQuery(jpql, Product.class).getResultList();
    } finally {
      em.close();
    }
  }

}
