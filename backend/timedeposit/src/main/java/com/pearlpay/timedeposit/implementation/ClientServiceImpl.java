package com.pearlpay.timedeposit.implementation;

import com.pearlpay.timedeposit.domain.Client;
import com.pearlpay.timedeposit.repo.ClientRepo;
import com.pearlpay.timedeposit.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    @Override
    public Client createClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Boolean deleteClient(Long id) {
        clientRepo.deleteById(id);
        return TRUE;
    }
}
