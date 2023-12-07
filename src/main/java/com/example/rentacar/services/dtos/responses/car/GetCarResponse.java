package com.example.rentacar.services.dtos.responses.car;

import com.example.rentacar.entities.Brand;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private int id;

    private String licensePlate;

    private String fuelType;

    private double rentalPrice;

    private String currentStatus;

}
