package com.keepcoding.service;

import com.keepcoding.entity.Propietario;
import com.keepcoding.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public Propietario save(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public Propietario findById(Long id) {
        return propietarioRepository.findById(id).orElse(null);
    }
}
