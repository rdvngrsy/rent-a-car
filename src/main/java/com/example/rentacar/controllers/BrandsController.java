package com.example.rentacar.controllers;

import com.example.rentacar.services.abstracts.BrandService;
import com.example.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandService brandService;


    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updatedBrand){
        brandService.update(id, updatedBrand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

    @GetMapping("/getByName")
    public List<GetBrandListResponse> getByName(@RequestParam String name, @RequestParam int id){
        return brandService.getByName(name,id);
    }

    @GetMapping("/getByNameStartingWith")
    public List<GetBrandListResponse> getByNameStartingWith(@RequestParam String letter){
        return brandService.getByNameStartingWith(letter);
    }

    @GetMapping("/getAll")
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/getAllBrandOrderByAlphabetical")
    public List<GetBrandListResponse> getAllBrandOrderByAlphabetical(){
        return brandService.getAllBrandOrderByAlphabetical();
    }
}
