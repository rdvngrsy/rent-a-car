package com.example.rentacar.controllers;

import com.example.rentacar.services.abstracts.CarService;
import com.example.rentacar.services.dtos.requests.car.AddCarRequest;
import com.example.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {

    private final CarService carService;

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,UpdateCarRequest updatedCar){
        carService.update(id, updatedCar);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

    @GetMapping("/getAll")
    public List<GetCarListResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/getByLicensePlate")
    public List<GetCarListResponse> getByLicensePlate(String licensePlate){
        return carService.getByLicensePlate(licensePlate);
    }

    @GetMapping("/getByRentalPriceBetween")
    public List<GetCarListResponse> getByRentalPriceBetween(double minPrice, double maxPrice){
        return carService.getByRentalPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/getCarByBranche")
    public List<GetCarListResponse> getCarByBranche(int brancheId){
        return carService.getCarByBranche(brancheId);
    }
}

