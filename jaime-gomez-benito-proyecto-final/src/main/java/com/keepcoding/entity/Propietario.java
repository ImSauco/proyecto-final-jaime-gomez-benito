package com.keepcoding.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "propietario")
    private List<Mascota> mascotas;
}