package com.pearlpay.timedeposit.project.portfolio.implementation;

import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;
import com.pearlpay.timedeposit.project.portfolio.repository.ClientRepo;
import com.pearlpay.timedeposit.project.portfolio.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public ClientDomain createClient(ClientDomain clientDomain) {
        return clientRepo.save(clientDomain);
    }

    @Override
    public List<ClientDomain> findAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public ClientDomain getClient(Integer id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public ClientDomain updateClient(ClientDomain clientDomain) {
        return clientRepo.save(clientDomain);
    }

    @Override
    public Boolean deleteClient(Integer id) {
        clientRepo.deleteById(id);
        return TRUE;
    }
}
