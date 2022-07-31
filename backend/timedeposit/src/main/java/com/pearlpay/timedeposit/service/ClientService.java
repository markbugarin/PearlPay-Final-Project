package com.pearlpay.timedeposit.service;

import com.pearlpay.timedeposit.domain.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);

    List<Client> findAllClients();

    Client getClient(Long id);

    Client updateClient(Client client);

    Boolean deleteClient(Long id);
}
