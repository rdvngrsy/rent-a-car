package com.example.rentacar.services.dtos.requests.car;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @NotBlank(message = "Araç plakası boş olamaz.")
    @Size(min = 7, max = 7, message = "Araç plakası 7 karakter olmalıdır.")
    private String licensePlate;

    @NotBlank(message = "Yakıt tipi boş olamaz.")
    private String fuelType;

    @Positive(message = "Kira fiyatı pozitif olmalıdır.")
    @NotBlank(message = "Kira fiyatı boş olamaz.")
    private double rentalPrice;

    @NotBlank(message = "Aracın mevcut durum boş olamaz.")
    private String currentStatus;
}
