package com.example.demo.controller;

import com.example.demo.service.MascotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping()
    public ResponseEntity<?> getMascota(){
        return ResponseEntity.ok(this.mascotaService.listarMascotas());
    }
}
