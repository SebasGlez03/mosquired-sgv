package com.persistence.impl;

import java.util.List;

import com.domain.RawMaterial;
import com.domain.util.JPAUtil;
import com.persistence.IRawMaterialDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RawMaterialDAO implements IRawMaterialDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a new Raw Material into the database
   *
   * @param rawMaterial RawMaterial that will be created
   */
  @Override
  public void create(RawMaterial rawMaterial) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.persist(rawMaterial);
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
   * Deteles a raw material from the database via an ID
   * 
   * @param id ID of the raw material to be deleted
   */
  @Override
  public void delete(Integer id) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      RawMaterial material = em.find(RawMaterial.class, id);
      if (material != null) {
        em.remove(material);
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
   * Finds a raw material from the database via an id
   * 
   * @param id ID of the raw materia to be found
   */
  @Override
  public RawMaterial find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(RawMaterial.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds a list of all the raw materials from the database
   */
  @Override
  public List<RawMaterial> findAll() {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("SELECT r FROM RawMaterial r", RawMaterial.class).getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Updates a raw material from the database
   * 
   * @param rawMaterial RawMaterial that will be updated
   */
  @Override
  public void update(RawMaterial rawMaterial) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.merge(rawMaterial);
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
