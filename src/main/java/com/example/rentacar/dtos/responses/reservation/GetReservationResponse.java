package com.example.rentacar.dtos.responses.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationResponse {
    private LocalDate startDate;

    private LocalDate endDate;

    private double totalPrice;
}
