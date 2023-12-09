package com.example.rentacar.controllers;


import com.example.rentacar.services.abstracts.ReservationService;
import com.example.rentacar.services.dtos.requests.reservation.AddReservationRequest;
import com.example.rentacar.services.dtos.requests.reservation.UpdateReservationRequest;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/reservations")
public class ReservationsController {
    private final ReservationService reservationService;

    @GetMapping
    public List<GetReservationListResponse> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("{id}")
    public GetReservationResponse getById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddReservationRequest request) {
        reservationService.add(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateReservationRequest updatedReservation) {
        reservationService.update(id, updatedReservation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        reservationService.delete(id);
    }

    @GetMapping("/getByStartDateAfter")
    public List<GetReservationListResponse> getByStartDateAfter(LocalDate startDate) {
        return reservationService.getByStartDateAfter(startDate);
    }

    @GetMapping("/getByEndDateBefore")
    public List<GetReservationListResponse> getByEndDateBefore(LocalDate endDate) {
        return reservationService.getByEndDateBefore(endDate);
    }

    @GetMapping("/getByTotalPriceLessThanEqual")
    public List<GetReservationListResponse> getByTotalPriceLessThanEqual(double totalPrice) {
        return reservationService.getByTotalPriceLessThanEqual(totalPrice);
    }

    @GetMapping("/getByTotalPriceGreaterThan")
    public List<GetReservationListResponse> getByTotalPriceGreaterThan(double totalPrice) {
        return reservationService.getByTotalPriceGreaterThan(totalPrice);
    }
}