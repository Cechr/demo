package com.example.demo.controller;

import com.example.demo.model.requestms.MascotaRequestVO;
import com.example.demo.service.MascotaService;

import com.example.demo.utils.ApiUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private ApiUtils apiUtils;
    @Autowired
    private MascotaService mascotaService;

    @GetMapping()
    public ResponseEntity<?> getMascotas(){
        return ResponseEntity.ok(this.mascotaService.listarMascotas());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postMascota(@Valid @RequestBody MascotaRequestVO requestVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return this.apiUtils.validarRequest(bindingResult);
        }
        return ResponseEntity.ok(this.mascotaService.guardarMascota(requestVO));
    }
}
