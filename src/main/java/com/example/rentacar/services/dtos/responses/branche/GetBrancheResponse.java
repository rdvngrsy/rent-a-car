package com.example.rentacar.services.dtos.responses.branche;

import com.example.rentacar.entities.Branche;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrancheResponse {
    private int id;
    private String name;

    private String address;

    private String managerName;

}
