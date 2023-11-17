package com.example.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")// Car classında brand attribute na mapleniyor.
    private List<Car> cars;

    @OneToMany(mappedBy = "brand")// Model classında brand attribute na mapleniyor.
    private List<Model> models;

}
