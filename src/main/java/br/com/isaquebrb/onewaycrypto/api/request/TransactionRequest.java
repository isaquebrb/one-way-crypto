package br.com.isaquebrb.onewaycrypto.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransactionRequest(@NotBlank String customerDocument, @NotBlank String cardNumber,
                                 @NotNull @Positive BigDecimal value) {

}