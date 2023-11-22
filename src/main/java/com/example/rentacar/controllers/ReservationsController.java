package com.example.rentacar.controllers;


import com.example.rentacar.dtos.requests.reservation.AddReservationRequest;
import com.example.rentacar.dtos.requests.reservation.UpdateReservationRequest;
import com.example.rentacar.dtos.responses.reservation.GetReservationResponse;
import com.example.rentacar.dtos.responses.reservation.GetReservationListResponse;
import com.example.rentacar.entities.Reservation;
import com.example.rentacar.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/reservations")
public class ReservationsController {
    private final ReservationRepository reservationRepository;

    @GetMapping
    public List<GetReservationListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetReservationResponse getById(@PathVariable int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow();

        GetReservationResponse dto = new GetReservationResponse();
        dto.setStartDate(reservation.getStartDate());
        dto.setEndDate(reservation.getEndDate());
        dto.setTotalPrice(reservation.getTotalPrice());
        
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddReservationRequest request){
        Reservation reservation = new Reservation();
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setTotalPrice(request.getTotalPrice());
        reservationRepository.save(reservation);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateReservationRequest updatedReservation){
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow();
        existingReservation.setStartDate(updatedReservation.getStartDate());
        existingReservation.setEndDate(updatedReservation.getEndDate());
        existingReservation.setTotalPrice(updatedReservation.getTotalPrice());
        reservationRepository.save(existingReservation);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservationToDelete);
    }
}
