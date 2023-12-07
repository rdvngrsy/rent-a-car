package com.example.rentacar.services.dtos.responses.car;


import com.example.rentacar.entities.Brand;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {

    public GetCarListResponse(int id, String licensePlate, String fuelType, double rentalPrice, String currentStatus) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.fuelType = fuelType;
        this.rentalPrice = rentalPrice;
        this.currentStatus = currentStatus;
    }


    private int id;

    private String licensePlate;

    private String fuelType;

    private double rentalPrice;

    private String currentStatus;

    private GetBrandListResponse brand;

    private GetBrancheListResponse branche;


}
