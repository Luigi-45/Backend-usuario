package com.Usuario.main.services.Usuario;

import com.Usuario.main.entities.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmailAndContrasenia(String email, String contrasenia);
    public Optional<Usuario> findByEmail(String email);
}
