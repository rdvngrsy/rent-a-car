package com.example.rentacar.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private String licensePlate;

    private String fuelType;

    private double rentalPrice;

    private String currentStatus;
}