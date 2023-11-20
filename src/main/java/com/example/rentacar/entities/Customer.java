package com.example.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phone",unique = true)
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "identity_number",unique = true)
    private String identityNumber;

    @OneToMany(mappedBy = "customer")// PaymentInformation classında customer attribute na mapleniyor.
    @JsonIgnore
    private List<PaymentInformation> paymentInformations;

    @OneToMany(mappedBy = "customer")// Reservation classında customer attribute na mapleniyor.
    @JsonIgnore
    private List<Reservation> reservations;
}
