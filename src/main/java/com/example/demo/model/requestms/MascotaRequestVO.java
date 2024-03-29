package com.example.demo.model.requestms;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MascotaRequestVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String fcNombre;
    @NotBlank
    private String fcDescripcion;
}
