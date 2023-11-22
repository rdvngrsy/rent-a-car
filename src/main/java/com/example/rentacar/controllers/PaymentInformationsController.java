package com.example.rentacar.controllers;



import com.example.rentacar.dtos.requests.paymentInformation.AddPaymentInformationRequest;
import com.example.rentacar.dtos.requests.paymentInformation.UpdatePaymentInformationRequest;
import com.example.rentacar.dtos.responses.paymentInformation.GetPaymentInformationListResponse;

import com.example.rentacar.dtos.responses.paymentInformation.GetPaymentInformationResponse;
import com.example.rentacar.entities.PaymentInformation;
import com.example.rentacar.repositories.PaymentInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/paymentinformations")
public class PaymentInformationsController {
    private final PaymentInformationRepository paymentInformationRepository;
    
    @GetMapping
    public List<GetPaymentInformationListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetPaymentInformationResponse getById(@PathVariable int id){
        PaymentInformation paymentInformation = paymentInformationRepository.findById(id).orElseThrow();

        GetPaymentInformationResponse dto = new GetPaymentInformationResponse();
        dto.setCardNumber(paymentInformation.getCardNumber());
        dto.setCardholderName(paymentInformation.getCardholderName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentInformationRequest request){
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardNumber(request.getCardNumber());
        paymentInformation.setExpirationDate(request.getExpirationDate());
        paymentInformation.setSecurityCode(request.getSecurityCode());
        paymentInformation.setCardholderName(request.getCardholderName());
        paymentInformationRepository.save(paymentInformation);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdatePaymentInformationRequest updatedPaymentInformation){
        PaymentInformation existingPaymentInformation = paymentInformationRepository.findById(id).orElseThrow();
        existingPaymentInformation.setCardNumber(updatedPaymentInformation.getCardNumber());
        existingPaymentInformation.setExpirationDate(updatedPaymentInformation.getExpirationDate());
        existingPaymentInformation.setSecurityCode(updatedPaymentInformation.getSecurityCode());
        existingPaymentInformation.setCardholderName(updatedPaymentInformation.getCardholderName());
        paymentInformationRepository.save(existingPaymentInformation);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        PaymentInformation paymentInformationToDelete = paymentInformationRepository.findById(id).orElseThrow();
        paymentInformationRepository.delete(paymentInformationToDelete);
    }
}
