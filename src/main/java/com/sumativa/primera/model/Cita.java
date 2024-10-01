package com.sumativa.primera.model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita extends RepresentationModel<Cita>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "fecha_hora")
    private Date fechaHora;
    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    @Column(name = "apellido_paciente")
    private String apellidoPaciente;
    @Column(name = "rut_paciente")
    private String rutPaciente;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "prevision", length = 1)
    private String prevision;
    @Column(name = "nombreDoctor")
    private String nombreDoctor;


    // Getters

    public Long getId() {
        return id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getRutPaciente() {
        return rutPaciente;
    }

    public Date gefechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPrevision() {
        return prevision;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }


    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public void setRutPaciente(String rut) {
        this.rutPaciente = rut;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

}