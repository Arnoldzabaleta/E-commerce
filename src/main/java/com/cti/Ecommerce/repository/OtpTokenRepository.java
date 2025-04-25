package com.cti.Ecommerce.repository;

import com.cti.Ecommerce.models.entities.OtpToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpTokenRepository extends JpaRepository<OtpToken,Integer> {
    Optional<OtpToken> findByToken(String token);
}
