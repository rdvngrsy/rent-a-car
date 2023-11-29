package com.example.rentacar.services.abstracts;

import com.example.rentacar.services.dtos.requests.customer.AddCustomerRequest;
import com.example.rentacar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest request);
    void update(int id, UpdateCustomerRequest updatedCustomer);
    void delete(int id);
}
