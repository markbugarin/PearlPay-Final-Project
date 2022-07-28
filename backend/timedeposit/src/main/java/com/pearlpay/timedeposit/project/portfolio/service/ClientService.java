package com.pearlpay.timedeposit.project.portfolio.service;

import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;

import java.util.List;

public interface ClientService {
    ClientDomain createClient(ClientDomain clientDomain);

    List<ClientDomain> findAllClients();

    ClientDomain getClient(Integer id);

    ClientDomain updateClient(ClientDomain clientDomain);

    Boolean deleteClient(Integer id);
}
