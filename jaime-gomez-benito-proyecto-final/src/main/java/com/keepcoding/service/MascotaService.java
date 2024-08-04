package com.keepcoding.service;

import com.keepcoding.entity.Mascota;
import com.keepcoding.repository.MascotaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public Page<Mascota> getMascotasPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mascotaRepository.findAll(pageable);
    }
        
        public Optional<Mascota> getById(Long id) {
            return mascotaRepository.findById(id);
        }

        public List<Mascota> getByNombre(String nombre) {
            return mascotaRepository.findByNombre(nombre);
        }

        public Mascota save(Mascota mascota) {
            return mascotaRepository.save(mascota);
        }

        public List<Mascota> getAll() {
            return mascotaRepository.findAll();
        }

        public List<Mascota> getYoungest() {
            return mascotaRepository.findAll(PageRequest.of(0, 20)).getContent();
        }

        public void deleteById(Long id) {
            mascotaRepository.deleteById(id);
        }

        public List<Mascota> getPaged(int page) {
            return mascotaRepository.findAll(PageRequest.of(page, 5)).getContent();
        }
    
    }