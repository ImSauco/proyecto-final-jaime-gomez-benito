package com.keepcoding.entity;
import lombok.Data;
import javax.persistence.*;

import java.time.LocalDate;


@Data
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaNac;
    private String raza;
    private int peso;
    private boolean tiene_chip;
    private String url_foto;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;
}