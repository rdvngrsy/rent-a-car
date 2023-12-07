package com.example.rentacar.repositories;

import com.example.rentacar.entities.PaymentInformation;
import com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PaymentInformationRepository extends JpaRepository<PaymentInformation,Integer> {

    List<PaymentInformation> findByCardholderNameOrderByCardNumberAsc(String cardholderName);
    List<PaymentInformation> findByCardNumber(String cardNumber);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse(p.id,p.cardNumber,p.cardholderName) FROM PaymentInformation p WHERE p.securityCode = :securityCode")
    List<GetPaymentInformationListResponse> getBySecurityCode(String securityCode);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.paymentInformation.GetPaymentInformationListResponse(p.id,p.cardNumber,p.cardholderName) FROM PaymentInformation p WHERE p.expirationDate < :expirationDate")
    List<GetPaymentInformationListResponse> getByExpirationDateBefore(LocalDate expirationDate);

}
