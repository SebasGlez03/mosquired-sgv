package com.persistence.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.domain.Sale;
import com.domain.util.JPAUtil;
import com.persistence.ISaleDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class SaleDAO implements ISaleDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a new sale into the database
   * 
   * @param sale Sale that will be created
   */
  @Override
  public void create(Sale sale) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.commit();
      em.persist(sale);
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
   * Finds a sale from the database via an id
   * 
   * @param id ID of the sale to be found
   */
  @Override
  public Sale find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Sale.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list of all the sales from the database
   */
  @Override
  public List<Sale> findAll() {
    EntityManager em = getEntityManager();
    try {
      // We ordered by descending date to see the last first
      return em.createQuery("SELECT s FROM Sale s ORDER BY s.saleDate DESC", Sale.class).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Find a list of sales by the client id
   * 
   * @param clientId ID of the client
   */
  @Override
  public List<Sale> findByClient(Integer clientId) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT s FROM Sale s WHERE s.client.idClient = :clientId ORDER BY s.saleDate DESC";
      return em.createQuery(jpql, Sale.class).setParameter("clientId", clientId).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list of sales by the range of dates
   * 
   * @param startDate Start date of the range
   * @param endDate   End date of the range
   */
  @Override
  public List<Sale> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT s FROM Sale s WHERE s.saleDate BETWEEN :start AND :end ORDER BY s.saleDate DESC";
      TypedQuery<Sale> query = em.createQuery(jpql, Sale.class);
      query.setParameter("start", startDate);
      query.setParameter("end", endDate);
      return query.getResultList();
    } finally {
      em.close();
    }
  }

}
