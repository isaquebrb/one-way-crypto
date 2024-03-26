package br.com.isaquebrb.onewaycrypto.service;

import br.com.isaquebrb.onewaycrypto.api.request.TransactionRequest;
import br.com.isaquebrb.onewaycrypto.api.response.TransactionResponse;
import br.com.isaquebrb.onewaycrypto.domain.entity.Transaction;
import br.com.isaquebrb.onewaycrypto.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final CryptoService cryptoService;

    public TransactionService(TransactionRepository repository, CryptoService cryptoService) {
        this.repository = repository;
        this.cryptoService = cryptoService;
    }

    public TransactionResponse createTransaction(TransactionRequest request) {
        String documentEncrypted = cryptoService.encrypt(request.customerDocument());
        String cardNumberEncrypted = cryptoService.encrypt(request.cardNumber());

        Transaction transaction = new Transaction(documentEncrypted, cardNumberEncrypted, request.value());

        repository.save(transaction);

        return new TransactionResponse(transaction.getCustomerDocument(), transaction.getCardNumber(),
                transaction.getValue(), transaction.getCreatedDate());
    }
}
