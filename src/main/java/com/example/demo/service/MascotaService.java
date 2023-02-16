package com.example.demo.service;

import com.example.demo.model.requestms.MascotaRequestVO;
import com.example.demo.model.responsems.MascotaResponseVO;

import java.util.Optional;

public interface MascotaService {
    Optional<MascotaResponseVO> listarMascotas();

    Optional<MascotaResponseVO> guardarMascota(MascotaRequestVO requestVO);
}
