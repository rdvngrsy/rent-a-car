package com.example.rentacar.services.concretes;


import com.example.rentacar.entities.Branche;
import com.example.rentacar.repositories.BrancheRepository;
import com.example.rentacar.services.abstracts.BrancheService;
import com.example.rentacar.services.dtos.requests.branche.AddBrancheRequest;
import com.example.rentacar.services.dtos.requests.branche.UpdateBrancheRequest;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrancheManager implements BrancheService {

    private final BrancheRepository brancheRepository;

    @Override
    public List<GetBrancheListResponse> getAll() {
        List<Branche> brancheList = brancheRepository.findAll();
        List<GetBrancheListResponse> getBrancheListResponses = new ArrayList<>();

        for (Branche branche : brancheList) {
            GetBrancheListResponse dto = new GetBrancheListResponse();
            dto.setId(branche.getId());
            dto.setName(branche.getName());
            dto.setAddress(branche.getAddress());
            dto.setManagerName(branche.getManagerName());
            getBrancheListResponses.add(dto);
        }
        return getBrancheListResponses;
    }

    @Override
    public GetBrancheResponse getById(int id) {
        Branche branche = brancheRepository.findById(id).orElseThrow();

        GetBrancheResponse dto = new GetBrancheResponse();
        dto.setName(branche.getName());
        dto.setAddress(branche.getAddress());
        dto.setManagerName(branche.getManagerName());

        return dto;
    }

    @Override
    public void add(AddBrancheRequest request) {
        Branche branche = new Branche();
        branche.setName(request.getName());
        branche.setAddress(request.getAddress());
        branche.setManagerName(request.getManagerName());
        brancheRepository.save(branche);
    }

    @Override
    public void update(int id, UpdateBrancheRequest updatedBranche) {
        Branche existingBrand = brancheRepository.findById(id).orElseThrow();
        existingBrand.setName(updatedBranche.getName());
        existingBrand.setAddress(updatedBranche.getAddress());
        existingBrand.setManagerName(updatedBranche.getManagerName());
        brancheRepository.save(existingBrand);
    }

    @Override
    public void delete(int id) {
        Branche brancheToDelete = brancheRepository.findById(id).orElseThrow();
        brancheRepository.delete(brancheToDelete);
    }

    @Override
    public List<GetBrancheListResponse> getByNameFirstLetter(String letter) {
        List<Branche> branches = brancheRepository.findByNameIgnoreCaseStartingWith(letter);
        List<GetBrancheListResponse> response = new ArrayList<>();

        for (Branche branche:branches) {
            response.add(new GetBrancheListResponse(branche.getId(),branche.getName(),branche.getAddress(),branche.getManagerName()));
        }
        return response;
    }

    @Override
    public List<GetBrancheListResponse> getByManagerBrancheInfo(String managerName) {
        List<Branche> branches = brancheRepository.findByManagerNameLikeIgnoreCase("%" + managerName + "%");
        List<GetBrancheListResponse> response = new ArrayList<>();

        for (Branche branche:branches) {
            response.add(new GetBrancheListResponse(branche.getId(),branche.getName(),branche.getAddress(),branche.getManagerName()));
        }
        return response;
    }

    @Override
    public List<GetBrancheListResponse> getWithNoAddress() {
        return brancheRepository.findWithNoAddress();
    }

    @Override
    public List<GetBrancheListResponse> getByAddress(String address) {
        return brancheRepository.findByAddress(address);
    }
}
