package com.example.rentacar.services.dtos.responses.branche;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrancheResponse {
    private String name;

    private String address;

    private String managerName;
}
