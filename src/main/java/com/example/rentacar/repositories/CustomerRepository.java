package com.example.rentacar.repositories;

import com.example.rentacar.entities.Customer;
import com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByIdentityNumberLike(String idNumber);
    List<Customer> findByEmailLikeIgnoreCase(String email);
    boolean existsByIdentityNumber(String idNumber);

    @Query("SELECT new com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse(c.id,c.firstName,c.lastName,c.email,c.phone,c.address) FROM Customer c WHERE LOWER(c.address) LIKE LOWER(concat('%', :keyword, '%'))")
    List<GetCustomerListResponse> getCustomersByAddressContaining(String keyword);


    @Query("SELECT new com.example.rentacar.services.dtos.responses.customer.GetCustomerListResponse(c.id,c.firstName,c.lastName,c.email,c.phone,c.address) FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(concat('%', :firstName, '%')) AND LOWER(c.lastName) LIKE LOWER(concat('%', :lastName, '%'))")
    List<GetCustomerListResponse> getCustomerByFullName(String firstName,String lastName);


}
