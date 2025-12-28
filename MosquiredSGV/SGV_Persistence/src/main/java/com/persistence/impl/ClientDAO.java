package com.persistence.impl;

import java.util.List;

import com.domain.Client;
import com.domain.util.JPAUtil;
import com.persistence.IClientDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ClientDAO implements IClientDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a client in the database
   * 
   * @param client Client to add in the database
   */
  @Override
  public void create(Client client) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.persist(client);
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
   * Deletes a client from the database
   * 
   * @param id ID of the client to delete
   */
  @Override
  public void delete(Integer id) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      Client client = em.find(Client.class, id);
      if (client != null) {
        em.remove(client);
      }
      tx.commit();
    } catch (Exception e) {
      if (tx.isActive())
        tx.rollback();
    } finally {
      em.close();
    }

  }

  /**
   * Finds a client via a given ID
   * 
   * @param id ID of the client to find
   */
  @Override
  public Client find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Client.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds all the list of clients
   */
  @Override
  public List<Client> findAll() {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list of clients by the name
   * 
   * @param name Name of the clients to find
   */
  @Override
  public List<Client> findByName(String name) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT c FROM Client c WHERE c.name LIKE :name";
      TypedQuery<Client> query = em.createQuery(jpql, Client.class);
      query.setParameter("name", "%" + name + "%");
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Updates a client from the database
   * 
   * @param client Client to update
   */
  @Override
  public void update(Client client) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.merge(client);
      tx.commit();
    } catch (Exception e) {
      if (tx.isActive())
        tx.rollback();
      throw e;
    } finally {
      em.close();
    }
  }

}
