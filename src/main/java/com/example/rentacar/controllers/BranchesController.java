package com.example.rentacar.controllers;


import com.example.rentacar.services.abstracts.BrancheService;
import com.example.rentacar.services.dtos.requests.branche.AddBrancheRequest;
import com.example.rentacar.services.dtos.requests.branche.UpdateBrancheRequest;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/branches")
public class BranchesController {

    private final BrancheService brancheService;

    @GetMapping
    public List<GetBrancheListResponse> getAll(){
        return brancheService.getAll();
    }

    @GetMapping("{id}")
    public GetBrancheResponse getById(@PathVariable int id){
        return brancheService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddBrancheRequest request){
        brancheService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, UpdateBrancheRequest updatedBranche){
        brancheService.update(id, updatedBranche);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brancheService.delete(id);
    }

    @GetMapping("/getByNameIgnoreCase")
    public List<GetBrancheListResponse> getByNameIgnoreCase(String name) {
        return brancheService.getByNameIgnoreCase(name);
    }

    @GetMapping("/getByNameStartingWith")
    public List<GetBrancheListResponse> getByNameFirstLetter(String letter){
        return brancheService.getByNameFirstLetter(letter);
    }

    @GetMapping("/getByManagerBrancheInfo")
    public List<GetBrancheListResponse> getByManagerBrancheInfo(String managerName){
        return brancheService.getByManagerBrancheInfo(managerName);
    }

    @GetMapping("/getWithNoAddress")
    public List<GetBrancheListResponse> getWithNoAddress(){
        return brancheService.getWithNoAddress();
    }

    @GetMapping("/getByAddress")
    public List<GetBrancheListResponse> getByAddress(String address){
        return brancheService.getByAddress(address);
    }
}
