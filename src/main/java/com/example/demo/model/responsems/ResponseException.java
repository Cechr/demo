package com.example.demo.model.responsems;

public class ResponseException extends RuntimeException{
    private final String codigo;
    private final String folio;

    public ResponseException(String mensaje, String codigo, String folio){
        super(mensaje);
        this.codigo = codigo;
        this.folio = folio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFolio() {
        return folio;
    }
}
