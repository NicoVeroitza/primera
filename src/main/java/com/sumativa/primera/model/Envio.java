package com.sumativa.primera.model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.time.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "envio")
public class Envio extends RepresentationModel<Envio>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "a_pagar")
    private boolean aPagar;
    @Column(name = "estado_envio")
    private String estadoEnvio;
    @Column(name = "ubicacion_actual")
    private String ubicacionActual;


    // Getters

    public Long getId() {
        return id;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public String geDireccionCliente() {
        return direccionCliente;
    }

    public boolean getAPagar() {
        return aPagar;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }


    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaHora(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void setRutCliente(String rut) {
        this.rutCliente = rut;
    }

    public void setDireccionCliente(String direccion) {
        this.direccionCliente = direccion;
    }

    public void setAPagar(boolean aPagar) {
        this.aPagar = aPagar;
    }

    public void setEstadoEnvio(String estado) {
        this.estadoEnvio = estado;
    }

    public void setUbicacionActual(String ubicacion) {
        this.ubicacionActual = ubicacion;
    }

}