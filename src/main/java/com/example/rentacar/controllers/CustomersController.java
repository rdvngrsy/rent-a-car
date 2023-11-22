package com.example.rentacar.controllers;


import com.example.rentacar.dtos.requests.customer.AddCustomerRequest;
import com.example.rentacar.dtos.requests.customer.UpdateCustomerRequest;
import com.example.rentacar.dtos.responses.branche.GetBrancheListResponse;
import com.example.rentacar.dtos.responses.branche.GetBrancheResponse;
import com.example.rentacar.dtos.responses.customer.GetCustomerListResponse;
import com.example.rentacar.dtos.responses.customer.GetCustomerResponse;
import com.example.rentacar.entities.Branche;
import com.example.rentacar.entities.Customer;
import com.example.rentacar.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;


    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        List<Customer> customerList = customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerListResponses = new ArrayList<>();

        for (Customer customer : customerList) {
            GetCustomerListResponse dto = new GetCustomerListResponse();
            dto.setId(customer.getId());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setEmail(customer.getEmail());
            dto.setPhone(customer.getPhone());
            dto.setAddress(customer.getAddress());
            getCustomerListResponses.add(dto);
        }
        return getCustomerListResponses;
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setIdentityNumber(request.getIdentityNumber());
        customerRepository.save(customer);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, UpdateCustomerRequest updatedCustomer){
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setIdentityNumber(updatedCustomer.getIdentityNumber());
        customerRepository.save(existingCustomer);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}
