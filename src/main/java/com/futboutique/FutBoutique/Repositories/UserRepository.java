package com.futboutique.FutBoutique.Repositories;



import com.futboutique.FutBoutique.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {

    @Query(value = "select * from usuario where email = :email and password = :senha",nativeQuery = true)
    public UserModel login(String email, String senha);
}