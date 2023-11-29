package com.example.rentacar.services.dtos.responses.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationListResponse {
    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private double totalPrice;
}
