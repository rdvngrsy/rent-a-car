package com.example.rentacar.controllers;

import com.example.rentacar.entities.Brand;
import com.example.rentacar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }


    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll(); // select * from brand gibi.
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        // Optional<T> => ilgili filtreden bir veri dönmeyebilir.Ondan orElseThrow gönderdik.
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody Brand brand){}

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

        // yada aynı işlevi yapan bu. Yukarıdaki daha işlevsel kontrol yapabilir.
        //brandRepository.deleteById(id);
    }

}
