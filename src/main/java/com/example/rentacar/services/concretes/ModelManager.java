package com.example.rentacar.services.concretes;


import com.example.rentacar.entities.Model;
import com.example.rentacar.repositories.ModelRepository;
import com.example.rentacar.services.abstracts.ModelService;
import com.example.rentacar.services.dtos.requests.model.AddModelRequest;
import com.example.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.example.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.example.rentacar.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    public final ModelRepository modelRepository;

    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> modelList = modelRepository.findAll();
        List<GetModelListResponse> getModelListResponses = new ArrayList<>();

        for (Model model : modelList) {
            GetModelListResponse dto = new GetModelListResponse();
            dto.setId(model.getId());
            dto.setName(model.getName());
            dto.setYear(model.getYear());
            getModelListResponses.add(dto);
        }
        return getModelListResponses;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();

        GetModelResponse dto = new GetModelResponse();
        dto.setName(model.getName());
        dto.setYear(model.getYear());
        return dto;
    }

    @Override
    public void add(AddModelRequest request) {
        if (modelRepository.existsByNameIgnoreCaseAndYear(request.getName(), request.getYear())){
            throw new RuntimeException("Girdiğiniz araç modeli ve yılı sistemimizde kayıtlıdır.");
        }

        Model model = new Model();
        model.setName(request.getName());
        model.setYear(request.getYear());
        modelRepository.save(model);
    }

    @Override
    public void update(int id, UpdateModelRequest updatedModel) {
        Model existingModel = modelRepository.findById(id).orElseThrow();
        existingModel.setName(updatedModel.getName());
        existingModel.setYear(updatedModel.getYear());
        modelRepository.save(existingModel);
    }

    @Override
    public void delete(int id) {
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);
    }

    @Override
    public List<GetModelListResponse> getByNameOrderByYearDesc(String name) {
        List<Model> models = modelRepository.findByNameOrderByYearDesc(name);
        List<GetModelListResponse> response = new ArrayList<>();

        for (Model model : models) {
            response.add(new GetModelListResponse(model.getId(),model.getName(),model.getYear()));
        }
        return response;
    }

    @Override
    public List<GetModelListResponse> getByYearGreaterThan(int year) {
        List<Model> models = modelRepository.findByYearGreaterThan(year);
        List<GetModelListResponse> response = new ArrayList<>();

        for (Model model : models) {
            response.add(new GetModelListResponse(model.getId(),model.getName(),model.getYear()));
        }
        return response;
    }

    @Override
    public List<GetModelListResponse> getModelsByYearRange(int startYear, int endYear) {
        return modelRepository.getModelsByYearRange(startYear, endYear);
    }

    @Override
    public List<GetModelListResponse> getOldestByModel(String model) {
        return modelRepository.getOldestByModel(model);
    }
}
