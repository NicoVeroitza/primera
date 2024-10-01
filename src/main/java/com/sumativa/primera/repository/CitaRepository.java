package com.sumativa.primera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumativa.primera.model.Cita;
import java.util.List;


public interface CitaRepository extends JpaRepository<Cita, Long>{

    List<Cita> findByNombreDoctor(String nombreDoctor);
    List<Cita> findByApellidoPaciente(String apellidoPaciente);
    Cita findByRutPaciente(String rutPaciente);
}