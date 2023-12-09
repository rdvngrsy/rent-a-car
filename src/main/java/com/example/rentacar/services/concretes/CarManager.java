package com.example.rentacar.services.concretes;

import com.example.rentacar.entities.Car;
import com.example.rentacar.repositories.CarRepository;
import com.example.rentacar.services.abstracts.CarService;
import com.example.rentacar.services.dtos.requests.car.AddCarRequest;
import com.example.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    public final CarRepository carRepository;

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setLicensePlate(car.getLicensePlate());
        dto.setFuelType(car.getFuelType());
        dto.setRentalPrice(car.getRentalPrice());
        dto.setCurrentStatus(car.getCurrentStatus());

        return dto;
    }

    @Override
    public void add(AddCarRequest request) {
        if (carRepository.existsByLicensePlateIgnoreCase(request.getLicensePlate())){
            throw new RuntimeException("Girdiğiniz plaka sistemimizde kayıtlıdır.");
        }

        Car car = new Car();
        car.setLicensePlate(request.getLicensePlate());
        car.setFuelType(request.getFuelType());
        car.setRentalPrice(request.getRentalPrice());
        car.setCurrentStatus(request.getCurrentStatus());
        carRepository.save(car);
    }

    @Override
    public void update(int id, UpdateCarRequest updatedCar) {
        Car existingCar = carRepository.findById(id).orElseThrow();
        existingCar.setLicensePlate(updatedCar.getLicensePlate());
        existingCar.setFuelType(updatedCar.getFuelType());
        existingCar.setRentalPrice(updatedCar.getRentalPrice());
        existingCar.setCurrentStatus(updatedCar.getCurrentStatus());
        carRepository.save(existingCar);
    }

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }


    @Override
    public List<GetCarListResponse> getByLicensePlate(String licensePlate) {
        List<Car> cars = carRepository.findByLicensePlateIgnoreCase(licensePlate);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car: cars) {
            response.add(new GetCarListResponse(car.getId(),car.getLicensePlate(),car.getFuelType(),car.getRentalPrice(),car.getCurrentStatus()));
        }
        return response;
    }

    @Override
    public List<GetCarListResponse> getByRentalPriceBetween(double minPrice, double maxPrice) {
        List<Car> cars = carRepository.findByRentalPriceBetween(minPrice,maxPrice);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car: cars) {
            response.add(new GetCarListResponse(car.getId(),car.getLicensePlate(),car.getFuelType(),car.getRentalPrice(),car.getCurrentStatus()));
        }
        return response;
    }

    @Override
    public List<GetCarListResponse> getAll() {
        return carRepository.getAll();
    }

    @Override
    public List<GetCarListResponse> getCarByBranche(int brancheId) {
        return carRepository.getCarByBranche(brancheId);
    }

}
