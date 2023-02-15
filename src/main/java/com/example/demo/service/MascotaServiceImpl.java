package com.example.demo.service;

import com.example.demo.entity.TaMascota;
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
}
