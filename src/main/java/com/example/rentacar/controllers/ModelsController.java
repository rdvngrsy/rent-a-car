package com.example.rentacar.controllers;

import com.example.rentacar.entities.Model;
import com.example.rentacar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {
    private final ModelRepository modelRepository;

    public ModelsController(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }


    @GetMapping
    public List<Model> getAll(){
        return modelRepository.findAll(); // select * from brand gibi.
    }

    @GetMapping("{id}")
    public Model getById(@PathVariable int id){
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Model model){
        modelRepository.save(model);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Model updatedModel){
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
