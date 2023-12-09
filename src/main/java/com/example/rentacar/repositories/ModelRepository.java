package com.example.rentacar.repositories;

import com.example.rentacar.entities.Model;
import com.example.rentacar.services.dtos.responses.model.GetModelListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    List<Model> findByNameOrderByYearDesc(String name);
    List<Model> findByYearGreaterThan(int year);
    boolean existsByNameIgnoreCaseAndYear(String name,int year);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.model.GetModelListResponse(m.id,m.name,m.year) FROM Model m WHERE m.year BETWEEN :startYear AND :endYear")
    List<GetModelListResponse> getModelsByYearRange(int startYear,int endYear);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.model.GetModelListResponse(m.id,m.name,m.year) FROM Model m WHERE  m.name = :model ORDER BY m.year ASC LIMIT 1")
    List<GetModelListResponse> getOldestByModel(String model);

}
