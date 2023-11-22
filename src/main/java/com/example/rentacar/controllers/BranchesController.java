package com.example.rentacar.controllers;


import com.example.rentacar.dtos.requests.branche.AddBrancheRequest;
import com.example.rentacar.dtos.requests.branche.UpdateBrancheRequest;
import com.example.rentacar.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.dtos.responses.branche.GetBrancheResponse;
import com.example.rentacar.entities.Branche;
import com.example.rentacar.repositories.BrancheRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/branches")
public class BranchesController {

    private final BrancheRepository brancheRepository;

    @GetMapping
    public List<GetBrancheListResponse> getAll(){
        List<Branche> brancheList = brancheRepository.findAll();
        List<GetBrancheListResponse> getBrancheListResponses = new ArrayList<>();

        for (Branche branche : brancheList) {
            GetBrancheListResponse dto = new GetBrancheListResponse();
            dto.setId(branche.getId());
            dto.setName(branche.getName());
            dto.setAddress(branche.getAddress());
            dto.setManagerName(branche.getManagerName());
            getBrancheListResponses.add(dto);
        }
        return getBrancheListResponses;
    }

    @GetMapping("{id}")
    public GetBrancheResponse getById(@PathVariable int id){
        Branche branche = brancheRepository.findById(id).orElseThrow();

        GetBrancheResponse dto = new GetBrancheResponse();
        dto.setName(branche.getName());
        dto.setAddress(branche.getAddress());
        dto.setManagerName(branche.getManagerName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrancheRequest request){
        Branche branche = new Branche();
        branche.setName(request.getName());
        branche.setAddress(request.getAddress());
        branche.setManagerName(request.getManagerName());
        brancheRepository.save(branche);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, UpdateBrancheRequest updatedBranche){
        Branche existingBrand = brancheRepository.findById(id).orElseThrow();
        existingBrand.setName(updatedBranche.getName());
        existingBrand.setAddress(updatedBranche.getAddress());
        existingBrand.setManagerName(updatedBranche.getManagerName());
        brancheRepository.save(existingBrand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Branche brancheToDelete = brancheRepository.findById(id).orElseThrow();
        brancheRepository.delete(brancheToDelete);
    }
}
