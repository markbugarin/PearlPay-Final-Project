package com.pearlpay.timedeposit.api;

import com.pearlpay.timedeposit.Response;
import com.pearlpay.timedeposit.domain.SecondaryAccount;
import com.pearlpay.timedeposit.implementation.SecondaryAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/secondary-account")
@RequiredArgsConstructor
public class SecondaryAccountController {
    private final SecondaryAccountServiceImpl secondaryAccountServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Response> saveAccount(@RequestBody SecondaryAccount secondaryAccount){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("secondary_accounts", secondaryAccountServiceImpl.createSecondAccount(secondaryAccount)))
                        .message("Secondary Account Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
