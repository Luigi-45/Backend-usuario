package com.Usuario.main.repositories;

import com.Usuario.main.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonalRepository extends JpaRepository<Personal,Integer> {
    Optional<Personal> findByEmail(String email);
}
