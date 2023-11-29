package com.example.rentacar.services.concretes;

import com.example.rentacar.entities.Brand;
import com.example.rentacar.repositories.BrandRepository;
import com.example.rentacar.services.abstracts.BrandService;
import com.example.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<GetBrandListResponse> getAll() {
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

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @Override
    public void add(AddBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(int id, UpdateBrandRequest updatedBrand) {
        Brand existingBrand = brandRepository.findById(id).orElseThrow();
        existingBrand.setName(updatedBrand.getName());
        brandRepository.save(existingBrand);
    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

        // yada aynı işlevi yapan bu. Yukarıdaki daha işlevsel kontrol yapabilir.
        //brandRepository.deleteById(id);
    }
}
