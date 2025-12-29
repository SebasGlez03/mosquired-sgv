package com.persistence.impl;

import java.util.List;

import com.domain.User;
import com.domain.util.JPAUtil;
import com.persistence.IUserDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/**
 * Data Access Oject Class for the Users
 */
public class UserDAO implements IUserDAO {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  /**
   * Creates a new user in the database
   * 
   * @param user User that is created in the database
   */
  @Override
  public void create(User user) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.persist(user);
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
   * Soft deletes a user from the system, disabling it but letting it in the
   * database
   * 
   * @param id Id of the user to delete
   */
  @Override
  public void delete(Integer id) {
    // Soft delete (recomended for users): change isActive to false
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      User user = em.find(User.class, id);
      if (user != null) {
        user.setIsActive(false);
        em.merge(user);
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
   * Finds a user in the database via an id
   * 
   * @param id ID of the user to find
   */
  @Override
  public User find(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(User.class, id);
    } finally {
      em.close();
    }
  }

  /**
   * Finds all the users in the database
   */
  @Override
  public List<User> findAll() {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT u FROM User u";
      TypedQuery<User> query = em.createQuery(jpql, User.class);
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  /**
   * Updates a user from the database
   * 
   * @param user User that will be updated
   */
  @Override
  public void update(User user) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.merge(user);
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
   * Login with username and password
   * 
   * @param username Username
   * @param password Password of the user
   */
  @Override
  public User login(String username, String password) {
    EntityManager em = getEntityManager();
    try {
      // NOTE: The password must be compare hashed
      String jpql = "SELECT u FROM User u WHERE u.username = :user AND u.password = :pass AND u.isActive = true";
      TypedQuery<User> query = em.createQuery(jpql, User.class);
      query.setParameter("user", username);
      query.setParameter("pass", password);
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    } finally {
      em.close();
    }
  }

  /**
   * Finds a user by its username
   * 
   * @param username Username
   */
  @Override
  public User findByUsername(String username) {
    EntityManager em = getEntityManager();
    try {
      String jpql = "SELECT u FROM User u WHERE u.username = :user AND i.isActive = true";
      TypedQuery<User> query = em.createQuery(jpql, User.class);
      query.setParameter("user", username);
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    } finally {
      em.close();
    }
  }

}
