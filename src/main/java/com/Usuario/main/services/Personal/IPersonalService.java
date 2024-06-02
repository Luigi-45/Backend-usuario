package com.Usuario.main.services.Personal;

import com.Usuario.main.entities.Personal;

import java.util.List;
import java.util.Optional;

public interface IPersonalService {

    Personal save(Personal personal);
    List<Personal> finndAll();
    Personal update(Personal personal);
    Optional<Personal> findById(int id);
    void delete(int id);
    public Optional<Personal> findByEmail(String email);
}
