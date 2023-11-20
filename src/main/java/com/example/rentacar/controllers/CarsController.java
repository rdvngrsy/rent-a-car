package com.example.rentacar.controllers;

import com.example.rentacar.entities.Car;
import com.example.rentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car updatedCar){
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

