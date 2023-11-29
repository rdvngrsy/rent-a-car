package com.example.rentacar.services.dtos.requests.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    private String licensePlate;

    private String fuelType;

    private double rentalPrice;

    private String currentStatus;
}
