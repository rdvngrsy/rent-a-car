package com.example.rentacar.services.abstracts;

import com.example.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.rentacar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest request);
    void update(int id,UpdateBrandRequest updatedBrand);
    void delete(int id);
}
