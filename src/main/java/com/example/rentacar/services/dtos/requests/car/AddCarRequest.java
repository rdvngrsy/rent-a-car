package com.example.rentacar.services.dtos.requests.car;


import com.example.rentacar.entities.Branche;
import com.example.rentacar.entities.Brand;
import com.example.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarResponse;
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
