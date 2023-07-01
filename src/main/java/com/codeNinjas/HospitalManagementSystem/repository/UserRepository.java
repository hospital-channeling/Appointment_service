package com.codeNinjas.HospitalManagementSystem.repository;

import com.codeNinjas.HospitalManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="SELECT * FROM Patient WHERE Id = ?1", nativeQuery = true)
    User getUserByID(int userID);

}
