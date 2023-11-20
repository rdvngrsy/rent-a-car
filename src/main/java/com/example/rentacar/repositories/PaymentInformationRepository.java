package com.example.rentacar.repositories;

import com.example.rentacar.entities.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInformationRepository extends JpaRepository<PaymentInformation,Integer> {
}
