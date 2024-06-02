package com.Usuario.main.repositories;

import com.Usuario.main.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmailAndContrasenia(String email, String contrasenia);
    Optional<Usuario> findByEmail(String email);
}
