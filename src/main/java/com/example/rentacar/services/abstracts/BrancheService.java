package com.example.rentacar.services.abstracts;

import com.example.rentacar.entities.Branche;
import com.example.rentacar.services.dtos.requests.branche.AddBrancheRequest;
import com.example.rentacar.services.dtos.requests.branche.UpdateBrancheRequest;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheResponse;

import java.util.List;

public interface BrancheService {
    List<GetBrancheListResponse> getAll();
    GetBrancheResponse getById(int id);
    void add(AddBrancheRequest request);
    void update(int id, UpdateBrancheRequest updatedBranche);
    void delete(int id);

    List<GetBrancheListResponse> getByNameIgnoreCase(String name);
    List<GetBrancheListResponse> getByNameFirstLetter(String letter);
    List<GetBrancheListResponse> getByManagerBrancheInfo(String managerName);
    List<GetBrancheListResponse> getWithNoAddress();
    List<GetBrancheListResponse> getByAddress(String address);

}
