package com.example.rentacar.services.abstracts;

import com.example.rentacar.entities.PaymentInformation;
import com.example.rentacar.services.dtos.requests.paymentInformation.AddPaymentInformationRequest;
import com.example.rentacar.services.dtos.requests.paymentInformation.UpdatePaymentInformationRequest;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationResponse;

import java.time.LocalDate;
import java.util.List;

public interface PaymentInformationService {
    List<GetPaymentInformationListResponse> getAll();
    GetPaymentInformationResponse getById(int id);
    void add(AddPaymentInformationRequest request);
    void update(int id,UpdatePaymentInformationRequest updatedPaymentInformation);
    void delete(int id);

    List<GetPaymentInformationListResponse> getByCardholderNameOrderByCardNumberAsc(String cardholderName);
    List<GetPaymentInformationListResponse> getByCardNumber(String cardNumber);


    List<GetPaymentInformationListResponse> getBySecurityCode(String securityCode);
    List<GetPaymentInformationListResponse> getByExpirationDateBefore(LocalDate expirationDate);

}
