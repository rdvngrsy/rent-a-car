package com.example.rentacar.repositories;

import com.example.rentacar.entities.Brand;
import com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    List<Brand> findByNameLikeOrIdEquals(String name,int id);
    List<Brand> findByNameIgnoreCaseStartingWith(String letter);

    @Query("Select new com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse(b.name) from Brand b")
    List<GetBrandListResponse> getAll();

    @Query("Select new com.example.rentacar.services.dtos.responses.brand.GetBrandListResponse(b.name) from Brand b ORDER BY b.name ASC")
    List<GetBrandListResponse> getAllBrandOrderByAlphabetical();


}
