package com.example.rentacar.services.dtos.responses.paymentInformation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentInformationListResponse {
    private int id;

    private String cardNumber;

    private String cardholderName;
}
