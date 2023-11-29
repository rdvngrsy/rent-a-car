package com.example.rentacar.controllers;

import com.example.rentacar.services.abstracts.CarService;
import com.example.rentacar.services.dtos.requests.car.AddCarRequest;
import com.example.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.rentacar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {

    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
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
}

