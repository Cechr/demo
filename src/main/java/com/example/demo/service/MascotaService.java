package com.example.demo.service;

import com.example.demo.model.requestms.MascotaRequestVO;
import com.example.demo.model.responsems.MascotaResponseVO;

import java.util.Optional;

public interface MascotaService {
    Optional<MascotaResponseVO> listarMascotas();

    Optional<MascotaResponseVO> obtenerMascota(Integer fiIdMascota);

    Optional<MascotaResponseVO> guardarMascota(MascotaRequestVO requestVO);

    Optional<MascotaResponseVO> actualizarMascota(Integer fiIdMascota, MascotaRequestVO requestVO);

    Optional<MascotaResponseVO> borrarMascota(Integer fiIdMascota);
}
