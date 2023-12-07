package com.example.rentacar.services.dtos.responses.paymentInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentInformationListResponse {
    private int id;

    private String cardNumber;

    private String cardholderName;
}
