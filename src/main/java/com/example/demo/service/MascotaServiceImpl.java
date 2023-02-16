package com.example.demo.service;

import com.example.demo.entity.TaMascota;
import com.example.demo.model.requestms.MascotaRequestVO;
import com.example.demo.model.responsems.MascotaResponseVO;
import com.example.demo.model.responsems.ResponseException;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.utils.ApiUtils;
import com.example.demo.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ApiUtils apiUtils;

    @Override
    @Transactional(readOnly = true)
    public Optional<MascotaResponseVO> listarMascotas(){
        MascotaResponseVO responseVO = new MascotaResponseVO();

        try {
            log.info("Búsqueda de todos las mascotas");
            responseVO.setMensaje(Constants.MENSAJE);
            responseVO.setFolio(Constants.FOLIO);
            responseVO.setResultado(Collections.singletonMap("mascotas", this.mascotaRepository.findAll()));
        }catch (Exception e){
            log.error("Error: " + e.getMessage());
            log.error("Method FolioServiceImpl.java -> saveFolio: " + this.apiUtils.mensajeError(e));
            throw new ResponseException(e.getMessage(), "500", e.getLocalizedMessage());
        }

        return Optional.of(responseVO);
    }

    @Override
    public Optional<MascotaResponseVO> obtenerMascota(Integer fiIdMascota) {
        MascotaResponseVO responseVO = new MascotaResponseVO();

        try {
            log.info("Búsqueda de todos las mascotas");
            responseVO.setMensaje(Constants.MENSAJE);
            responseVO.setFolio(Constants.FOLIO);
            responseVO.setResultado(Collections.singletonMap("mascotas", this.mascotaRepository.findById(Long.valueOf(fiIdMascota))));
        }catch (Exception e){
            log.error("Error: " + e.getMessage());
            log.error("Method FolioServiceImpl.java -> saveFolio: " + this.apiUtils.mensajeError(e));
            throw new ResponseException(e.getMessage(), "500", e.getLocalizedMessage());
        }

        return Optional.of(responseVO);
    }

    @Override
    public Optional<MascotaResponseVO> guardarMascota(MascotaRequestVO requestVO) {
        TaMascota mascota = new TaMascota();
        MascotaResponseVO responseVO = new MascotaResponseVO();

        try {
            mascota.setFcNombre(requestVO.getFcNombre());
            mascota.setFcDescripcion(requestVO.getFcDescripcion());
            this.mascotaRepository.save(mascota);
            log.info("Mascota registrada");
            responseVO.setMensaje(Constants.MENSAJE);
            responseVO.setFolio(Constants.FOLIO);
            responseVO.setResultado(Collections.singletonMap("mascota", mascota));
        }catch (Exception e){
            log.error("Error: " + e.getMessage());
            log.error("Method FolioServiceImpl.java -> saveFolio: " + this.apiUtils.mensajeError(e));
            throw new ResponseException(e.getMessage(), "500", e.getLocalizedMessage());
        }

        return Optional.of(responseVO);
    }

    @Override
    public Optional<MascotaResponseVO> actualizarMascota(Integer fiIdMascota, MascotaRequestVO requestVO) {
        MascotaResponseVO responseVO = new MascotaResponseVO();

        try {
            this.mascotaRepository.findById(Long.valueOf(fiIdMascota))
                    .map(mascota -> {
                        mascota.setFcNombre(requestVO.getFcNombre());
                        mascota.setFcDescripcion((requestVO.getFcDescripcion()));
                        this.mascotaRepository.save(mascota);
                        log.info("Mascota actualizada");
                        responseVO.setMensaje(Constants.MENSAJE);
                        responseVO.setFolio(Constants.FOLIO);
                        responseVO.setResultado(Collections.singletonMap("mascota", mascota));
                        return responseVO;
                    });
        }catch (Exception e){
            log.error("Error: " + e.getMessage());
            log.error("Method FolioServiceImpl.java -> saveFolio: " + this.apiUtils.mensajeError(e));
            throw new ResponseException(e.getMessage(), "500", e.getLocalizedMessage());
        }

        return Optional.of(responseVO);
    }

    @Override
    public Optional<MascotaResponseVO> borrarMascota(Integer fiIdMascota) {
        MascotaResponseVO responseVO = new MascotaResponseVO();

        try {
            this.mascotaRepository.deleteById(Long.valueOf(fiIdMascota));
            log.info("Mascota borrada");
            responseVO.setMensaje(Constants.MENSAJE);
            responseVO.setFolio(Constants.FOLIO);
            responseVO.setResultado(Collections.singletonMap("mascota", "Mascota con fiIdMascota= " + fiIdMascota + " borrada correctamente"));
        }catch (Exception e){
            log.error("Error: " + e.getMessage());
            log.error("Method FolioServiceImpl.java -> saveFolio: " + this.apiUtils.mensajeError(e));
            throw new ResponseException(e.getMessage(), "500", e.getLocalizedMessage());
        }

        return Optional.of(responseVO);
    }
}
