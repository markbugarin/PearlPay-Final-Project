package com.pearlpay.timedeposit.api;

import com.pearlpay.timedeposit.Response;
import com.pearlpay.timedeposit.domain.Client;
import com.pearlpay.timedeposit.implementation.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllClients(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("clients", clientServiceImpl.findAllClients()))
                        .message("Clients Found.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveClient(@RequestBody Client client){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("clients", clientServiceImpl.createClient(client)))
                        .message("Client Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
