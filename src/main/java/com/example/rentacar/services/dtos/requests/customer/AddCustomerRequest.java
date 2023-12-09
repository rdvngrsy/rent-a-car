package com.example.rentacar.services.dtos.requests.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = "Ad boş olamaz.")
    @Size(min = 1, max = 50, message = "Ad 1 ile 50 karakter arasında olmalıdır.")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz.")
    @Size(min = 1, max = 50, message = "Soyad 1 ile 50 karakter arasında olmalıdır.")
    private String lastName;

    @NotBlank(message = "E-posta boş olamaz.")
    @Email(message = "Geçersiz e-posta formatı.")
    private String email;

    @NotBlank(message = "Telefon numarası boş olamaz.")
    @Pattern(regexp = "\\d{10}", message = "Telefon numaranızı başında 0 olmadan giriniz.")
    private String phone;

    @NotBlank(message = "Adres boş olamaz.")
    private String address;

    @NotBlank(message = "Kimlik numarası boş olamaz.")
    @Size(min = 11, max = 11, message = "Kimlik numarası 11 karakter olmalıdır.")
    private String identityNumber;

}
