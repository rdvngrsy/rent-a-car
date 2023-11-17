package com.example.rentacar.entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "payment_informations")
public class PaymentInformation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_number",unique = true)
    private String cardNumber;

    @Column(name = "expiration_date", columnDefinition = "date")
    private LocalDate expirationDate;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
