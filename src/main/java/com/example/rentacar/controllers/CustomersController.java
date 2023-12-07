package com.example.rentacar.controllers;


import com.example.rentacar.services.abstracts.CustomerService;
import com.example.rentacar.services.dtos.requests.customer.AddCustomerRequest;
import com.example.rentacar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;


    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
       customerService.add(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, UpdateCustomerRequest updatedCustomer){
        customerService.update(id, updatedCustomer);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @GetMapping("/getByIdentityNumberFromCustomer")
    public List<GetCustomerListResponse> getByIdentityNumberFromCustomer(String idNumber) {
        return customerService.getByIdentityNumberFromCustomer(idNumber);
    }

    @GetMapping("/getByEmailFromCustomer")
    public List<GetCustomerListResponse> getByEmailFromCustomer(String email){
        return customerService.getByEmailFromCustomer(email);
    }

    @GetMapping("/getCustomersByAddress")
    List<GetCustomerListResponse> getCustomersByAddressContaining(String keyword){
        return customerService.getCustomersByAddressContaining(keyword);
    }

    @GetMapping("/getCustomerByFullName")
    List<GetCustomerListResponse> getCustomerByFullName(String firstName,String lastName){
        return customerService.getCustomerByFullName(firstName, lastName);
    }


}
