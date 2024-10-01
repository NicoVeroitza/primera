package com.sumativa.primera.dto;

public class EnvioDTO {
    public Long id;
    public String estado;

    public Long getId(){
        return id;
    }

    public String getEstado(){
        return estado;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setEstado(String estado){
        this.estado=estado;
    }
}
