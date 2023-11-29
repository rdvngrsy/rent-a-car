package com.example.rentacar.services.dtos.requests.branche;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrancheRequest {
    private String name;

    private String address;

    private String managerName;
}
