package com.example.rentacar.repositories;

import com.example.rentacar.entities.Reservation;
import com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    List<Reservation> findByStartDateAfter(LocalDate startDate);
    List<Reservation> findByEndDateBefore(LocalDate endDate);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse(r.id, r.startDate, r.endDate, r.totalPrice) FROM Reservation r WHERE r.totalPrice <= :totalPrice")
    List<GetReservationListResponse> getByTotalPriceLessThanEqual(double totalPrice);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.reservation.GetReservationListResponse(r.id, r.startDate, r.endDate, r.totalPrice) FROM Reservation r WHERE r.totalPrice > :totalPrice")
    List<GetReservationListResponse> getByTotalPriceGreaterThan(double totalPrice);


}
