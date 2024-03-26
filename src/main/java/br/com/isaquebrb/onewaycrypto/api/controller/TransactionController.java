package br.com.isaquebrb.onewaycrypto.api.controller;

import br.com.isaquebrb.onewaycrypto.api.request.TransactionRequest;
import br.com.isaquebrb.onewaycrypto.api.response.TransactionResponse;
import br.com.isaquebrb.onewaycrypto.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody @Valid TransactionRequest request) {
        return new ResponseEntity<>(service.createTransaction(request), HttpStatus.CREATED);
    }
}
