package com.business.impl;

import org.mindrot.jbcrypt.BCrypt;

import com.business.IUserBO;
import com.domain.User;
import com.dtos.UserDTO;
import com.persistence.IUserDAO;
import com.persistence.impl.UserDAO;

public class UserBO implements IUserBO {

  // DAO dependency
  private final IUserDAO userDAO = new UserDAO();

  /**
   * Log in with the credentials of the user usin a hashed password
   * 
   * @param username      Username
   * @param plainPassword Password to be hashed and finded
   */
  @Override
  public UserDTO login(String username, String plainPassword) {
    // 1. Find a user by its username (without validating the password yet)
    User user = userDAO.findByUsername(username);

    if (user == null) {
      return null; // Usert didn't exist
    }

    // 2. Verify password with BCrypt
    // checkpq compares the plain text with the saved hash in the database
    if (BCrypt.checkpw(plainPassword, user.getPassword())) {

      // 3. If it matches, we convert Entity -> DTO and we return
      return new UserDTO(user.getIdUser(), user.getFullName(), user.getUsername(), user.getRole(), user.getIsActive());
    } else {
      return null; // Incorrect password
    }
  }

  /**
   * Registers a new user using the info of the user and a plain password to be
   * hashed
   * 
   * @param userDTO      DTO object that contains all the information of the user
   * @param planPassword Pasword in plain text to be hashed
   */
  @Override
  public void registerUser(UserDTO userDTO, String plainPassword) {
    // 1. Convert DTO to Entity
    User user = new User();
    user.setFullName(userDTO.getFullName());
    user.setUsername(userDTO.getUsername());
    user.setRole(userDTO.getRole());
    user.setIsActive(true); // active by default at register

    // 2. hash the password with BCrypt
    // gensalt() generates a random safe salt
    String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    user.setPassword(hashedPassword);

    // 3. Save in database
    userDAO.create(user);
  }

}
