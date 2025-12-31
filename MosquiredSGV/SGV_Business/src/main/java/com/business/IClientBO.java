package com.business;

import java.util.List;

import com.dtos.ClientDTO;

public interface IClientBO {

  void addClient(ClientDTO clientDTO);

  void updateClient(ClientDTO clientDTO);

  void deleteClient(Integer id);

  ClientDTO getClientById(Integer id);

  List<ClientDTO> getAllClients();

  List<ClientDTO> searchClientsByName(String name);

}
