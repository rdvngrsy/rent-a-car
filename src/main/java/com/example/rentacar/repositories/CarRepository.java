package com.example.rentacar.repositories;

import com.example.rentacar.entities.Car;
import com.example.rentacar.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {


    List<Car> findByLicensePlateIgnoreCase(String licensePlate);
    List<Car> findByRentalPriceBetween(double minPrice, double maxPrice);
    boolean existsByLicensePlateIgnoreCase(String licensePlate);

    @Query("Select new com.example.rentacar.services.dtos.responses.car.GetCarListResponse(c.id, c.licensePlate, c.fuelType, c.rentalPrice, c.currentStatus, new com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse(b.name), new com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse(br.id,br.name,br.address,br.managerName)) " +
           "From Car c INNER JOIN c.brand b INNER JOIN c.branche br ")

    List<GetCarListResponse> getAll();

    @Query("Select new com.example.rentacar.services.dtos.responses.car.GetCarListResponse(c.id, c.licensePlate, c.fuelType, c.rentalPrice, c.currentStatus, new com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse(b.name), new com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse(br.id,br.name,br.address,br.managerName))" +
            "From Car c INNER JOIN c.brand b INNER JOIN c.branche br WHERE br.id = :brancheId")
    List<GetCarListResponse> getCarByBranche(int brancheId);

}
