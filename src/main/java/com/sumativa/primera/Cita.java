package com.sumativa.primera;

import java.time.LocalDateTime;

public class Cita {
    private int id;
    private LocalDateTime fechaHora;
    private String rutPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;

    public Cita(){

    }

    public Cita(int id, LocalDateTime fechaHora, String rut, String nombre, String apellido){
        this.id = id;
        this.fechaHora = fechaHora;
        this.rutPaciente = rut;
        this.nombrePaciente = nombre;
        this.apellidoPaciente = apellido;

    }

    public int getId(){
        return id;
    }

    public LocalDateTime getFechaHora(){
        return fechaHora;
    }

    public String getRut(){
        return rutPaciente;
    }

    public String getNombreApellido(){
        return nombrePaciente + " " + apellidoPaciente;
    }
}
