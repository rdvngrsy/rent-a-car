package com.example.rentacar.services.concretes;

import com.example.rentacar.entities.Customer;
import com.example.rentacar.repositories.CustomerRepository;
import com.example.rentacar.services.abstracts.CustomerService;
import com.example.rentacar.services.dtos.requests.customer.AddCustomerRequest;
import com.example.rentacar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    public final CustomerRepository customerRepository;

    @Override
    public List<GetCustomerListResponse> getAll() {
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

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());

        return dto;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setIdentityNumber(request.getIdentityNumber());
        customerRepository.save(customer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setIdentityNumber(updatedCustomer.getIdentityNumber());
        customerRepository.save(existingCustomer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<GetCustomerListResponse> getByIdentityNumberFromCustomer(String idNumber) {
        List<Customer> customers = customerRepository.findByIdentityNumberLike("%" + idNumber + "%");
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer : customers) {
            response.add(new GetCustomerListResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getAddress()));
        }
        return response;
    }

    @Override
    public List<GetCustomerListResponse> getByEmailFromCustomer(String email) {
        List<Customer> customers = customerRepository.findByEmailLikeIgnoreCase("%" + email + "%");
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer : customers) {
            response.add(new GetCustomerListResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getAddress()));
        }
        return response;
    }

    @Override
    public List<GetCustomerListResponse> getCustomersByAddressContaining(String keyword) {
        return customerRepository.getCustomersByAddressContaining(keyword);
    }

    @Override
    public List<GetCustomerListResponse> getCustomerByFullName(String firstName, String lastName) {
        return customerRepository.getCustomerByFullName(firstName,lastName);
    }
}
