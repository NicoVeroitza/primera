package com.sumativa.primera;

import java.time.LocalDateTime;

public class Envio {
    private int id;
    private LocalDateTime fechaEnvio;
    private String nombreCliente;
    private String apellidoCliente;
    private String ubicacionActual;


    public Envio(){

    }

    public Envio(int id, LocalDateTime fecha, String nombre, String apellido, String ubicacion){
        this.id = id;
        this.fechaEnvio = fecha;
        this.nombreCliente = nombre;
        this.apellidoCliente = apellido;
        this.ubicacionActual = ubicacion;
    }

    public int getId(){  
        return id;
    }

    public LocalDateTime getFecha(){
        return fechaEnvio;
    }

    public String getNombreApellido(){
        return nombreCliente + " " + apellidoCliente;
    }

    public String getUbicacion(){
        return ubicacionActual;
    }
}
