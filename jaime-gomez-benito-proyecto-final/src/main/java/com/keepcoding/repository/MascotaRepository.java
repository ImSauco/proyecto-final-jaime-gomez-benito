package com.keepcoding.repository;

import com.keepcoding.entity.Mascota;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);
    
    Page<Mascota> findAllByOrderByFechaNacDesc(Pageable pageable);
}