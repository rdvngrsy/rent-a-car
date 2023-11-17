package com.example.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "rental_price")
    private double rentalPrice;

    @Column(name = "current_status")
    private String currentStatus;

    //Foreign key olan kısıma bunları yazıyoruz.
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "branche_id")
    private Branche branche;

    @OneToMany(mappedBy = "car")// Reservation classında car attribute na mapleniyor.
    private List<Reservation> reservations;


}
