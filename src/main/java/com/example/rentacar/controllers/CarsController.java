package com.example.rentacar.controllers;

import com.example.rentacar.dtos.requests.car.AddCarRequest;
import com.example.rentacar.dtos.requests.car.UpdateCarRequest;
import com.example.rentacar.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.dtos.responses.branche.GetBrancheResponse;
import com.example.rentacar.dtos.responses.car.GetCarListResponse;
import com.example.rentacar.dtos.responses.car.GetCarResponse;
import com.example.rentacar.entities.Branche;
import com.example.rentacar.entities.Car;
import com.example.rentacar.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    @GetMapping
    public List<GetCarListResponse> getAll(){
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : carList) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setId(car.getId());
            dto.setLicensePlate(car.getLicensePlate());
            dto.setFuelType(car.getFuelType());
            dto.setRentalPrice(car.getRentalPrice());
            dto.setCurrentStatus(car.getCurrentStatus());

            getCarListResponses.add(dto);
        }
        return getCarListResponses;
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setLicensePlate(car.getLicensePlate());
        dto.setFuelType(car.getFuelType());
        dto.setRentalPrice(car.getRentalPrice());
        dto.setCurrentStatus(car.getCurrentStatus());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        Car car = new Car();
        car.setLicensePlate(request.getLicensePlate());
        car.setFuelType(request.getFuelType());
        car.setRentalPrice(request.getRentalPrice());
        car.setCurrentStatus(request.getCurrentStatus());
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,UpdateCarRequest updatedCar){
        Car existingCar = carRepository.findById(id).orElseThrow();
        existingCar.setLicensePlate(updatedCar.getLicensePlate());
        existingCar.setFuelType(updatedCar.getFuelType());
        existingCar.setRentalPrice(updatedCar.getRentalPrice());
        existingCar.setCurrentStatus(updatedCar.getCurrentStatus());
        carRepository.save(existingCar);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);

    }
}

