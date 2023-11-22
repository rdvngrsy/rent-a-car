package com.example.rentacar.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private String licensePlate;

    private String fuelType;

    private double rentalPrice;

    private String currentStatus;
}
