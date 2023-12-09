package com.example.rentacar.controllers;

import com.example.rentacar.services.abstracts.ModelService;
import com.example.rentacar.services.dtos.requests.model.AddModelRequest;
import com.example.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.example.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.example.rentacar.services.dtos.responses.model.GetModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/models")
public class ModelsController {
    private final ModelService modelService;

    @GetMapping
    public List<GetModelListResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddModelRequest request){
        modelService.add(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateModelRequest updatedModel){
        modelService.update(id, updatedModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }

    @GetMapping("/getByNameOrderByYearDesc")
    public List<GetModelListResponse> getByNameOrderByYearDesc(String name){
        return modelService.getByNameOrderByYearDesc(name);
    }

    @GetMapping("/getByYearGreaterThan")
    public List<GetModelListResponse> getByYearGreaterThan(int year) {
        return modelService.getByYearGreaterThan(year);
    }

    @GetMapping("/getModelsByYearRange")
    List<GetModelListResponse> getModelsByYearRange(int startYear,int endYear){
        return modelService.getModelsByYearRange(startYear, endYear);
    }

    @GetMapping("/getOldestByModel")
    List<GetModelListResponse> getOldestByModel(String model){
        return modelService.getOldestByModel(model);
    }

}
