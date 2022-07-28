package com.pearlpay.timedeposit.project.portfolio.resource;

import com.pearlpay.timedeposit.project.portfolio.Response;
import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;
import com.pearlpay.timedeposit.project.portfolio.implementation.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientResource {
    private final ClientServiceImpl clientServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Response> saveClient(@RequestBody ClientDomain clientDomain){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("clients", clientServiceImpl.createClient(clientDomain)))
                        .message("Client Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
