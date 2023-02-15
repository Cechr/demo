package com.example.demo.repository;

import com.example.demo.entity.TaMascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<TaMascota, Long> {
}
