package com.pearlpay.timedeposit.api;

import com.pearlpay.timedeposit.Response;
import com.pearlpay.timedeposit.domain.Checking;
import com.pearlpay.timedeposit.implementation.CheckingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/checking")
@RequiredArgsConstructor
public class CheckingController {
    private final CheckingServiceImpl checkingServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllChecking(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("checking", checkingServiceImpl.findAllChecking()))
                        .message("Checking Created")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveChecking(@RequestBody Checking checking){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("checking", checkingServiceImpl.createChecking(checking)))
                        .message("Checking Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

}
