package com.example.rentacar.services.abstracts;

import com.example.rentacar.services.dtos.requests.paymentInformation.AddPaymentInformationRequest;
import com.example.rentacar.services.dtos.requests.paymentInformation.UpdatePaymentInformationRequest;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationResponse;

import java.util.List;

public interface PaymentInformationService {
    List<GetPaymentInformationListResponse> getAll();
    GetPaymentInformationResponse getById(int id);
    void add(AddPaymentInformationRequest request);
    void update(int id,UpdatePaymentInformationRequest updatedPaymentInformation);
    void delete(int id);
}
