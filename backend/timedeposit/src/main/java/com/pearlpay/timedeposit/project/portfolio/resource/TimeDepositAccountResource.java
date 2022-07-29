package com.pearlpay.timedeposit.project.portfolio.resource;

import com.pearlpay.timedeposit.project.portfolio.Response;
import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;
import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;
import com.pearlpay.timedeposit.project.portfolio.implementation.ClientServiceImpl;
import com.pearlpay.timedeposit.project.portfolio.implementation.TimeDepositAccountImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/time-deposit-account")
@RequiredArgsConstructor
public class TimeDepositAccountResource {

    private final TimeDepositAccountImpl timeDepositAccountImpl;
    private final ClientServiceImpl clientService;


    @PostMapping("/save")
    public ResponseEntity<Response> saveAccount(@RequestParam("accountNumber") String accountNumber, @RequestParam("clientId") int clientId){

        ClientDomain clientDomain = clientService.getClient(clientId);
        TimeDepositAccountDomain timeDepositAccount = TimeDepositAccountDomain.builder()
                .accountNumber(accountNumber)
                .clientDomain(clientDomain)
                .accountStatus(true)
                .build();
        timeDepositAccountImpl.createAccount(timeDepositAccount);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("accounts",timeDepositAccount))
                        .message("Account Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
