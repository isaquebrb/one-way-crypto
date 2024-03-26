package br.com.isaquebrb.onewaycrypto.api.response;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(String customerDocument, String cardNumber, BigDecimal value,
                                  LocalDateTime createdDate) {

}
