package com.example.rentacar.services.dtos.requests.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank(message = "Model adı boş olamaz.")
    @Size(min = 2, max = 50, message = "Model adı 1 ile 50 karakter arasında olmalıdır.")
    private String name;

    @Positive(message = "Yıl pozitif bir değer olmalıdır.")
    private int year;
}
