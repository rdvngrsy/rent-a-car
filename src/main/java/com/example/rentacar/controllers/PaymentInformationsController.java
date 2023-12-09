package com.example.rentacar.controllers;


import com.example.rentacar.services.abstracts.PaymentInformationService;
import com.example.rentacar.services.dtos.requests.paymentInformation.AddPaymentInformationRequest;
import com.example.rentacar.services.dtos.requests.paymentInformation.UpdatePaymentInformationRequest;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/paymentinformations")
public class PaymentInformationsController {
    private final PaymentInformationService paymentInformationService;

    @GetMapping
    public List<GetPaymentInformationListResponse> getAll() {
        return paymentInformationService.getAll();
    }

    @GetMapping("{id}")
    public GetPaymentInformationResponse getById(@PathVariable int id) {
        return paymentInformationService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentInformationRequest request) {
        paymentInformationService.add(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdatePaymentInformationRequest updatedPaymentInformation) {
        paymentInformationService.update(id, updatedPaymentInformation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentInformationService.delete(id);
    }

    @GetMapping("/getByCardholderNameOrderByCardNumberAsc")
    public List<GetPaymentInformationListResponse> getByCardholderNameOrderByCardNumberAsc(String cardholderName) {
        return paymentInformationService.getByCardholderNameOrderByCardNumberAsc(cardholderName);
    }

    @GetMapping("/getByCardNumber")
    public List<GetPaymentInformationListResponse> getByCardNumber(String cardNumber) {
        return paymentInformationService.getByCardNumber(cardNumber);
    }

    @GetMapping("/getBySecurityCode")
    public List<GetPaymentInformationListResponse> getBySecurityCode(String securityCode) {
        return paymentInformationService.getBySecurityCode(securityCode);
    }

    @GetMapping("/getByExpirationDateBefore")
    public List<GetPaymentInformationListResponse> getByExpirationDateBefore(LocalDate expirationDate) {
        return paymentInformationService.getByExpirationDateBefore(expirationDate);
    }
}