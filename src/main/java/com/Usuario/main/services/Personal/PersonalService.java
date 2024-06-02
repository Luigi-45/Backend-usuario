package com.Usuario.main.services.Personal;

import com.Usuario.main.entities.Personal;
import com.Usuario.main.exceptions.ResourceNotFoundException;
import com.Usuario.main.repositories.IPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService implements IPersonalService{

    @Autowired
    private IPersonalRepository personalRepository;

    @Override
    public Personal save(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public List<Personal> finndAll() {
        return personalRepository.findAll();
    }

    @Override
    public Personal update(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Optional<Personal> findById(int id) {
        return Optional.ofNullable(personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el personal con el id: " + id)));
    }

    @Override
    public void delete(int id) {
        personalRepository.deleteById(id);
    }

    @Override
    public Optional<Personal> findByEmail(String email) {
        return personalRepository.findByEmail(email);
    }
}
