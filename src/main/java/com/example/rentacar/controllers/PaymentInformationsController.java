package com.example.rentacar.controllers;


import com.example.rentacar.entities.PaymentInformation;
import com.example.rentacar.repositories.PaymentInformationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paymentinformations")
public class PaymentInformationsController {
    private final PaymentInformationRepository paymentInformationRepository;

    public PaymentInformationsController(PaymentInformationRepository paymentInformationRepository){
        this.paymentInformationRepository = paymentInformationRepository;
    }


    @GetMapping
    public List<PaymentInformation> getAll(){
        return paymentInformationRepository.findAll();
    }

    @GetMapping("{id}")
    public PaymentInformation getById(@PathVariable int id){
        return paymentInformationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentInformation paymentInformation){
        paymentInformationRepository.save(paymentInformation);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody PaymentInformation updatedPaymentInformation){
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
