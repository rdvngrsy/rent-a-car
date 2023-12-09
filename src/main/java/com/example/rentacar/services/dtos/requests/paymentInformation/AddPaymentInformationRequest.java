package com.example.rentacar.services.dtos.requests.paymentInformation;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentInformationRequest {
    @NotBlank(message = "Kart numarası boş olamaz.")
    @Size(min = 16, max = 16, message = "Geçersiz kart numarası formatı.")
    private String cardNumber;

    @FutureOrPresent(message = "Geçersiz son kullanma tarihi.")
    private LocalDate expirationDate;

    @NotBlank(message = "Güvenlik kodu boş olamaz.")
    @Size(min = 3, max = 3, message = "Geçersiz güvenlik kodu formatı.")
    private String securityCode;

    @NotBlank(message = "Kart sahibi adı boş olamaz.")
    private String cardholderName;
}
