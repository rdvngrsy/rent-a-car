package com.example.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")// Car classında brand attribute na mapleniyor.
    @JsonIgnore                   // Bu alan jsona parse edilirken yok sayılcak. Sonsuz döngü var burda çünkü.
    private List<Car> cars;

    @OneToMany(mappedBy = "brand")// Model classında brand attribute na mapleniyor.
    @JsonIgnore
    private List<Model> models;

}
