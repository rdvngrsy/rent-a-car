package com.example.rentacar.services.concretes;

import com.example.rentacar.entities.Reservation;
import com.example.rentacar.repositories.ReservationRepository;
import com.example.rentacar.services.abstracts.ReservationService;
import com.example.rentacar.services.dtos.requests.reservation.AddReservationRequest;
import com.example.rentacar.services.dtos.requests.reservation.UpdateReservationRequest;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationManager implements ReservationService {

    public final ReservationRepository reservationRepository;

    @Override
    public List<GetReservationListResponse> getAll() {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<GetReservationListResponse> getReservationListResponses = new ArrayList<>();

        for (Reservation reservation : reservationList) {
            GetReservationListResponse dto = new GetReservationListResponse();
            dto.setId(reservation.getId());
            dto.setStartDate(reservation.getStartDate());
            dto.setEndDate(reservation.getEndDate());
            dto.setTotalPrice(reservation.getTotalPrice());
            getReservationListResponses.add(dto);
        }
        return getReservationListResponses;
    }

    @Override
    public GetReservationResponse getById(int id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();

        GetReservationResponse dto = new GetReservationResponse();
        dto.setStartDate(reservation.getStartDate());
        dto.setEndDate(reservation.getEndDate());
        dto.setTotalPrice(reservation.getTotalPrice());

        return dto;
    }

    @Override
    public void add(AddReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setTotalPrice(request.getTotalPrice());
        reservationRepository.save(reservation);
    }

    @Override
    public void update(int id, UpdateReservationRequest updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow();
        existingReservation.setStartDate(updatedReservation.getStartDate());
        existingReservation.setEndDate(updatedReservation.getEndDate());
        existingReservation.setTotalPrice(updatedReservation.getTotalPrice());
        reservationRepository.save(existingReservation);
    }

    @Override
    public void delete(int id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservationToDelete);
    }
}
