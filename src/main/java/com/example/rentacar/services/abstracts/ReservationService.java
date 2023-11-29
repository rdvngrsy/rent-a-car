package com.example.rentacar.services.abstracts;

import com.example.rentacar.services.dtos.requests.reservation.AddReservationRequest;
import com.example.rentacar.services.dtos.requests.reservation.UpdateReservationRequest;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationResponse;

import java.util.List;

public interface ReservationService {
    List<GetReservationListResponse> getAll();
    GetReservationResponse getById(int id);
    void add(AddReservationRequest request);
    void update(int id,UpdateReservationRequest updatedReservation);
    void delete(int id);
}
