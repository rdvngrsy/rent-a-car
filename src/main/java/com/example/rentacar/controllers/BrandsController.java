package com.example.rentacar.controllers;

import com.example.rentacar.dtos.requests.brand.AddBrandRequest;
import com.example.rentacar.dtos.requests.brand.UpdateBrandRequest;
import com.example.rentacar.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.dtos.responses.brand.GetBrandResponse;
import com.example.rentacar.entities.Branche;
import com.example.rentacar.entities.Brand;
import com.example.rentacar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;



    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();

        for (Brand brand : brandList) {
            GetBrandListResponse dto = new GetBrandListResponse();
            dto.setId(brand.getId());
            dto.setName(brand.getName());
            getBrandListResponses.add(dto);
        }
        return getBrandListResponses;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updatedBrand){
        Brand existingBrand = brandRepository.findById(id).orElseThrow();
        existingBrand.setName(updatedBrand.getName());
        brandRepository.save(existingBrand);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

        // yada aynı işlevi yapan bu. Yukarıdaki daha işlevsel kontrol yapabilir.
        //brandRepository.deleteById(id);
    }

}
