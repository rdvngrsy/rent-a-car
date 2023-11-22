package com.example.rentacar.controllers;

import com.example.rentacar.dtos.requests.model.AddModelRequest;
import com.example.rentacar.dtos.requests.model.UpdateModelRequest;
import com.example.rentacar.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.dtos.responses.branche.GetBrancheResponse;
import com.example.rentacar.dtos.responses.model.GetModelListResponse;
import com.example.rentacar.dtos.responses.model.GetModelResponse;
import com.example.rentacar.entities.Branche;
import com.example.rentacar.entities.Model;
import com.example.rentacar.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/models")
public class ModelsController {
    private final ModelRepository modelRepository;

    @GetMapping
    public List<GetModelListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        Model model = modelRepository.findById(id).orElseThrow();

        GetModelResponse dto = new GetModelResponse();
        dto.setName(model.getName());
        dto.setYear(model.getYear());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddModelRequest request){
        Model model = new Model();
        model.setName(request.getName());
        model.setYear(request.getYear());
        modelRepository.save(model);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateModelRequest updatedModel){
        Model existingModel = modelRepository.findById(id).orElseThrow();
        existingModel.setName(updatedModel.getName());
        existingModel.setYear(updatedModel.getYear());
        modelRepository.save(existingModel);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);
    }
}
