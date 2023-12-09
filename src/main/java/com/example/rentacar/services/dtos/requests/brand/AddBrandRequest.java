package com.example.rentacar.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "Marka adı boş olamaz.")
    @Size(min = 2, max = 20, message = "Marka adı 1 ile 20 karakter arasında olmalıdır.")
    private String name;
}

