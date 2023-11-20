package com.example.rentacar.controllers;


import com.example.rentacar.entities.Reservation;
import com.example.rentacar.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {
    private final ReservationRepository reservationRepository;

    public ReservationsController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }


    @GetMapping
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable int id){
        return reservationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Reservation updatedReservation){
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
