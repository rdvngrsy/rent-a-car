package com.example.rentacar.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

}
