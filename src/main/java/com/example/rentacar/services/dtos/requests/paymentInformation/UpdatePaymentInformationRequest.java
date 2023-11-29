package com.example.rentacar.services.dtos.requests.paymentInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentInformationRequest {
    private String cardNumber;

    private LocalDate expirationDate;

    private String securityCode;

    private String cardholderName;
}
