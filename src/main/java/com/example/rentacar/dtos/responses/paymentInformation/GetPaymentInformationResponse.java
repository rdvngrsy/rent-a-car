package com.example.rentacar.dtos.responses.paymentInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentInformationResponse {
    private String cardNumber;

    private String cardholderName;
}
