package com.example.rentacar.repositories;

import com.example.rentacar.entities.Branche;
import com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrancheRepository extends JpaRepository<Branche,Integer> {

    List<Branche> findByNameIgnoreCaseStartingWith(String letter);
    List<Branche> findByManagerNameLikeIgnoreCase(String managerName);

    // Belirli bir adrese sahip olmayan şubeleri getirme
    @Query("SELECT new com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse(b.id, b.name, b.address, b.managerName) FROM Branche b WHERE b.address IS NULL OR b.address = ''")
    List<GetBrancheListResponse> findWithNoAddress();

    // Belirli bir adres girdisi ile bilgileri getirme
    @Query("SELECT new com.example.rentacar.services.dtos.responses.branche.GetBrancheListResponse(b.id, b.name, b.address, b.managerName) FROM Branche b WHERE LOWER(b.address) LIKE LOWER(concat('%', :address, '%'))")
    List<GetBrancheListResponse> findByAddress(String address);
}
