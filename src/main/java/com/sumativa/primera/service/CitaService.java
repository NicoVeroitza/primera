package com.sumativa.primera.service;

import com.sumativa.primera.model.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<Cita> getAllCitas();
    Optional<Cita> getCitaById(Long id);
    
}
