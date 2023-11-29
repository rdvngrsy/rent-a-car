package com.example.rentacar.services.abstracts;

import com.example.rentacar.services.dtos.requests.car.AddCarRequest;
import com.example.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest request);
    void update(int id, UpdateCarRequest updatedCar);
    void delete(int id);
}
