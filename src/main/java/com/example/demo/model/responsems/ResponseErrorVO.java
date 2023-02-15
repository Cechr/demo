package com.example.demo.model.responsems;

import java.util.ArrayList;
import java.util.List;

public class ResponseErrorVO {
    public String codigo;
    public String mensaje;
    public String folio;
    public String info;
    public List<String> detalles;

    public ResponseErrorVO() {
    }

    public ResponseErrorVO(String codigo, String mensaje, String folio, String info) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
        this.info = info;
        this.detalles = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }
}
