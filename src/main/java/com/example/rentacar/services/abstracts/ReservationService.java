package com.example.rentacar.services.abstracts;

import com.example.rentacar.entities.Reservation;
import com.example.rentacar.services.dtos.requests.reservation.AddReservationRequest;
import com.example.rentacar.services.dtos.requests.reservation.UpdateReservationRequest;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<GetReservationListResponse> getAll();
    GetReservationResponse getById(int id);
    void add(AddReservationRequest request);
    void update(int id,UpdateReservationRequest updatedReservation);
    void delete(int id);

    List<GetReservationListResponse> getByStartDateAfter(LocalDate startDate);
    List<GetReservationListResponse> getByEndDateBefore(LocalDate endDate);

    List<GetReservationListResponse> getByTotalPriceLessThanEqual(double totalPrice);
    List<GetReservationListResponse> getByTotalPriceGreaterThan(double totalPrice);

}
