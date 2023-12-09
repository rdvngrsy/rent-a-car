package com.example.rentacar.services.dtos.requests.reservation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationRequest {
    @NotNull(message = "Başlangıç tarihi boş olamaz.")
    @FutureOrPresent(message = "Geçersiz başlangıç tarihi.")
    private LocalDate startDate;

    @Future(message = "Geçersiz bitiş tarihi.")
    private LocalDate endDate;

    @Positive(message = "Toplam fiyat pozitif bir değer olmalıdır.")
    @NotNull(message = "Toplam fiyat boş olamaz.")
    private double totalPrice;
}
