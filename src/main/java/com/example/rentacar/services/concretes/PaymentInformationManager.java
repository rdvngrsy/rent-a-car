package com.example.rentacar.services.concretes;

import com.example.rentacar.entities.PaymentInformation;
import com.example.rentacar.repositories.PaymentInformationRepository;
import com.example.rentacar.services.abstracts.PaymentInformationService;
import com.example.rentacar.services.dtos.requests.paymentInformation.AddPaymentInformationRequest;
import com.example.rentacar.services.dtos.requests.paymentInformation.UpdatePaymentInformationRequest;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentInformationManager implements PaymentInformationService {

    public final PaymentInformationRepository paymentInformationRepository;

    @Override
    public List<GetPaymentInformationListResponse> getAll() {
        List<PaymentInformation> paymentInformationList = paymentInformationRepository.findAll();
        List<GetPaymentInformationListResponse> getPaymentInformationListResponses = new ArrayList<>();

        for (PaymentInformation paymentInformation : paymentInformationList) {
            GetPaymentInformationListResponse dto = new GetPaymentInformationListResponse();
            dto.setId(paymentInformation.getId());
            dto.setCardNumber(paymentInformation.getCardNumber());
            dto.setCardholderName(paymentInformation.getCardholderName());
            getPaymentInformationListResponses.add(dto);
        }
        return getPaymentInformationListResponses;
    }

    @Override
    public GetPaymentInformationResponse getById(int id) {
        PaymentInformation paymentInformation = paymentInformationRepository.findById(id).orElseThrow();

        GetPaymentInformationResponse dto = new GetPaymentInformationResponse();
        dto.setCardNumber(paymentInformation.getCardNumber());
        dto.setCardholderName(paymentInformation.getCardholderName());

        return dto;
    }

    @Override
    public void add(AddPaymentInformationRequest request) {
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardNumber(request.getCardNumber());
        paymentInformation.setExpirationDate(request.getExpirationDate());
        paymentInformation.setSecurityCode(request.getSecurityCode());
        paymentInformation.setCardholderName(request.getCardholderName());
        paymentInformationRepository.save(paymentInformation);
    }

    @Override
    public void update(int id, UpdatePaymentInformationRequest updatedPaymentInformation) {
        PaymentInformation existingPaymentInformation = paymentInformationRepository.findById(id).orElseThrow();
        existingPaymentInformation.setCardNumber(updatedPaymentInformation.getCardNumber());
        existingPaymentInformation.setExpirationDate(updatedPaymentInformation.getExpirationDate());
        existingPaymentInformation.setSecurityCode(updatedPaymentInformation.getSecurityCode());
        existingPaymentInformation.setCardholderName(updatedPaymentInformation.getCardholderName());
        paymentInformationRepository.save(existingPaymentInformation);
    }

    @Override
    public void delete(int id) {
        PaymentInformation paymentInformationToDelete = paymentInformationRepository.findById(id).orElseThrow();
        paymentInformationRepository.delete(paymentInformationToDelete);
    }
}
