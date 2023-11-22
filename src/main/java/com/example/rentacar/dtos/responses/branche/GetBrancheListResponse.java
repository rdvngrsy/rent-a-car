package com.example.rentacar.dtos.responses.branche;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrancheListResponse {
    private int id;

    private String name;

    private String address;

    private String managerName;
}
