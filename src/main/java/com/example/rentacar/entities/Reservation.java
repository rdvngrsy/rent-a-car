package com.example.rentacar.entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date",columnDefinition = "date")
    private LocalDate startDate;

    @Column(name = "end_date",columnDefinition = "date")
    private LocalDate endDate;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
