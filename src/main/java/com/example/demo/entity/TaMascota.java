package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TAMASCOTA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaMascota implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FIID_MASCOTA", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fiIdMascota;

    @Column(name = "FCNOMBRE")
    private String fcNombre;

    @Column(name = "FCDESCRIPCION")
    private String fcDescripcion;
}
