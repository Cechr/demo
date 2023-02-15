package com.example.demo.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class ApiUtils {

    /*public ResponseEntity<?> validarRequest(BindingResult bindingResult){
        return ResponseEntity.badRequest().body(crearResponseError(bindingResult, null, 1));
    }*/

    /*public ResponseErrorVO crearResponseError(BindingResult bindingResult, Exception e, int a){
        ResponseErrorVO errorVO = new ResponseErrorVO();
        errorVO.setCodigo(a == 1 ? "API.OA-400" : "API.OA-500");
        errorVO.setMensaje(a == 1 ? "Datos de entrada incorrectos, por favor valide su información" : "Error al realizar la operación, favor de validar");
        errorVO.setFolio(UUID.randomUUID().toString());
        errorVO.setInfo("http://10.88.82.154:8083/info#400");
        errorVO.setDetalles(a == 1 ?
                bindingResult.getFieldErrors().stream().map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage()).toList()
                :Collections.singletonList(e.getMessage()));
        log.warn(errorVO.getDetalles().toString());
        log.warn("Mas detalles ApiUtils.java -> crearResponseError(): " + mensajeError(e));
        return errorVO;
    }

    public String formatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
        return format.format(date);
    }*/

    public String mensajeError(Exception e){
        if(e == null){
            return "No existe informacion";
        }
        final StringBuilder builder = new StringBuilder();
        builder.append("\nTipo de Excepcion: ").append(e.getClass().getName());
        builder.append("\nFecha: ").append((new Date()).toString());
        builder.append("\nMensaje: ").append((e.getMessage() == null) ? "" : e.getMessage());

        for (int i = 0; i < e.getStackTrace().length; i++){
            final StackTraceElement stackTraceElement;
            stackTraceElement = e.getStackTrace()[i];
            builder.append("\nLocalizacion[").append(i + 1).append("]: ").append(stackTraceElement.getClassName());
            builder.append(".").append(stackTraceElement.getMethodName());
            builder.append("(").append(stackTraceElement.getFileName()).append(")");
            builder.append(":").append(stackTraceElement.getLineNumber());
        }
        if(e.getCause() != null){
            builder.append("\n\nCausado por: ").append(e.getCause());
            if(e.getCause().getStackTrace() != null){
                for (int i = 0; i < e.getCause().getStackTrace().length; i++){
                    final StackTraceElement stackTraceElement;
                    stackTraceElement = e.getCause().getStackTrace()[i];
                    builder.append("\nLocalizacion[").append(i + 1).append("]: ").append(stackTraceElement.getClassName());
                    builder.append(".").append(stackTraceElement.getMethodName());
                    builder.append("(").append(stackTraceElement.getFileName()).append(")");
                    builder.append(":").append(stackTraceElement.getLineNumber());
                }
            }
        }
        return builder.toString();
    }
}
