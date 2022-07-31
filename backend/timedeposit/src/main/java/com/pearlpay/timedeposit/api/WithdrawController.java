package com.pearlpay.timedeposit.api;

import com.pearlpay.timedeposit.Response;
import com.pearlpay.timedeposit.domain.Withdraw;
import com.pearlpay.timedeposit.implementation.WithdrawServiceImpl;
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
@RequestMapping("/api/v1/withdraw")
@RequiredArgsConstructor
public class WithdrawController {
    private final WithdrawServiceImpl withdrawServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Response> saveAccount(@RequestBody Withdraw withdraw){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("withdraw", withdrawServiceImpl.createWithdraw(withdraw)))
                        .message("Withdraw Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
