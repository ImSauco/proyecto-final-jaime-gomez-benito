package com.keepcoding.controller.api;

import com.keepcoding.entity.Propietario;
import com.keepcoding.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @PostMapping
    public Propietario agregarPropietario(@RequestBody Propietario propietario) {
        return propietarioService.save(propietario);
    }

    @GetMapping("/{id}/mascotas")
    public Propietario mostrarMascotasPorPropietario(@PathVariable Long id) {
        return propietarioService.findById(id);
    }
}