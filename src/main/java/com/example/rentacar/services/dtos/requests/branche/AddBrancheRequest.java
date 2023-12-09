package com.example.rentacar.services.dtos.requests.branche;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrancheRequest {
    @NotBlank(message = "Şube adı boş olamaz.")
    @Size(min = 2, max = 30, message = "Şube adı 1 ile 20 karakter arasında olmalıdır.")
    private String name;

    @NotBlank(message = "Adres boş olamaz.")
    private String address;

    @NotBlank(message = "Yönetici adı boş olamaz.")
    @Size(min = 1, max = 50, message = "Yönetici adı 1 ile 50 karakter arasında olmalıdır.")
    private String managerName;
}
