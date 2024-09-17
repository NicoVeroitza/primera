package com.sumativa.primera.service;

import com.sumativa.primera.model.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    Cita crearCita(Cita cita);
    String cancelarCita(Long id);
    String consultarDisponibilidad(String nombreDoctor);
    
}
