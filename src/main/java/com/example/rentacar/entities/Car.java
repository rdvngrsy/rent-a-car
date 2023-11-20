package com.example.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    @JsonIgnore
    private Model model;

    @ManyToOne
    @JoinColumn(name = "branche_id")
    @JsonIgnore
    private Branche branche;

    @OneToMany(mappedBy = "car")// Reservation classında car attribute na mapleniyor.
    @JsonIgnore
    private List<Reservation> reservations;


}
