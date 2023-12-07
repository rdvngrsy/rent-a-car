package com.example.rentacar.services.abstracts;

import com.example.rentacar.entities.Model;
import com.example.rentacar.services.dtos.requests.model.AddModelRequest;
import com.example.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.example.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.example.rentacar.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest request);
    void update(int id,UpdateModelRequest updatedModel);
    void delete(int id);

    List<GetModelListResponse> getByNameOrderByYearDesc(String name);
    List<GetModelListResponse> getByYearGreaterThan(int year);

    List<GetModelListResponse> getModelsByYearRange(int startYear,int endYear);
    List<GetModelListResponse> getOldestByModel(String model);

}
