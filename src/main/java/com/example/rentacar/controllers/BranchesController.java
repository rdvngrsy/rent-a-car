package com.example.rentacar.controllers;


import com.example.rentacar.entities.Branche;
import com.example.rentacar.repositories.BrancheRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branches")
public class BranchesController {

    private final BrancheRepository brancheRepository;

    public BranchesController(BrancheRepository brancheRepository){
        this.brancheRepository = brancheRepository;
    }

    @GetMapping
    public List<Branche> getAll(){
        return brancheRepository.findAll();
    }

    @GetMapping("{id}")
    public Branche getById(@PathVariable int id){
        return brancheRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Branche branche){
        brancheRepository.save(branche);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, Branche updatedBranche){
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
