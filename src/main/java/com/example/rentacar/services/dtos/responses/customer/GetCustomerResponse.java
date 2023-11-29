package com.example.rentacar.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

}
