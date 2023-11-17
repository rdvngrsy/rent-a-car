package com.example.rentacar.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "branches")
public class Branche {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "branche")// Car classında branche attribute na mapleniyor.
    private List<Car> cars;

}
