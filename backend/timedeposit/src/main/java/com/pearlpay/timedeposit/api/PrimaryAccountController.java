package com.pearlpay.timedeposit.api;

import com.pearlpay.timedeposit.Response;
import com.pearlpay.timedeposit.domain.PrimaryAccount;
import com.pearlpay.timedeposit.implementation.ClientServiceImpl;
import com.pearlpay.timedeposit.implementation.PrimaryAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/primary-account")
@RequiredArgsConstructor
public class PrimaryAccountController {
    private final PrimaryAccountServiceImpl primaryAccountServiceImpl;
    private final ClientServiceImpl clientServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Response> saveAccount(@RequestBody PrimaryAccount primaryAccount){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("accounts", primaryAccountServiceImpl.createAccount(primaryAccount)))
                        .message("Account Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getClient(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("accounts", clientServiceImpl.findAllClients()))
                        .message("Client Found.")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
