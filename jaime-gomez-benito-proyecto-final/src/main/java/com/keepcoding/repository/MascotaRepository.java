package com.keepcoding.repository;

import com.keepcoding.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByNombre(String nombre);
}