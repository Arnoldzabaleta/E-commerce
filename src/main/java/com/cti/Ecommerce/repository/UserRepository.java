package com.cti.Ecommerce.repository;

import com.cti.Ecommerce.models.entities.User;
import com.cti.Ecommerce.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByEmail(String email);

    List<User> findByAccountStatus(Status status);
}
