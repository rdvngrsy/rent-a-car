package com.example.rentacar.dtos.requests.paymentInformation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentInformationRequest {
    private String cardNumber;

    private LocalDate expirationDate;

    private String securityCode;

    private String cardholderName;
}
