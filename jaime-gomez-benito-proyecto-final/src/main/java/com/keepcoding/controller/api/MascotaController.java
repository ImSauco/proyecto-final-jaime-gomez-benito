package com.keepcoding.controller.api;

import com.keepcoding.entity.Mascota;
import com.keepcoding.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/{id}")
    public Optional<Mascota> getById(@PathVariable Long id) {
        return mascotaService.getById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Mascota> getByNombre(@PathVariable String nombre) {
        return mascotaService.getByNombre(nombre);
    }

    @PostMapping
    public Mascota save(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota);
    }

    @GetMapping
    public List<Mascota> getAll() {
        return mascotaService.getAll();
    }

   
    @GetMapping("/youngest")
    public List<Mascota> getYoungest() {
        Page<Mascota> page = mascotaService.getYoungest(20);
        return page.getContent();
    }

    @GetMapping("/page/{page}")
    public List<Mascota> getPaged(@PathVariable int page) {
        return mascotaService.getPaged(page);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        mascotaService.deleteById(id);
    }
}