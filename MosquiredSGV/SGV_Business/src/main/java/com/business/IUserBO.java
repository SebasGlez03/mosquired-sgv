package com.business;

import com.dtos.UserDTO;

public interface IUserBO {

  void registerUser(UserDTO userDTO, String plainPassword);

  UserDTO login(String username, String plainPassword);
}
