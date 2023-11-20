package com.example.rentacar.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "payment_informations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
