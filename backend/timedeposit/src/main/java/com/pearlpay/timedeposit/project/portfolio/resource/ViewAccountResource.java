package com.pearlpay.timedeposit.project.portfolio.resource;

import com.pearlpay.timedeposit.project.portfolio.Response;
import com.pearlpay.timedeposit.project.portfolio.implementation.ClientServiceImpl;
import com.pearlpay.timedeposit.project.portfolio.implementation.TimeDepositAccountImpl;
import com.pearlpay.timedeposit.project.portfolio.implementation.ViewAccountServiceImpl;
import com.pearlpay.timedeposit.project.portfolio.output.TimeDeposit;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class ViewAccountResource {

    private final ClientServiceImpl clientServiceImpl;

    @GetMapping("/retrieve")
    public ResponseEntity<Response> getAllAccounts(){

        List<TimeDeposit> timeDeposits = new ArrayList<>();
        clientServiceImpl.findAllClients().forEach(e->{
            e.getTimeDepositAccounts().forEach(i->{
                timeDeposits.add(new TimeDeposit(e.getFirstName(),e.getLastName(),i.getBalance()));
            });

        });

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("clients",timeDeposits))
                        .message("Accounts Retrieve")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
