package com.sumativa.primera.service;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.sumativa.primera.model.Cita;
import com.sumativa.primera.repository.CitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita crearCita(Cita cita){
        
        return citaRepository.save(cita);
        
    }

    @Override
    public String cancelarCita(Long id){
        if(citaRepository.existsById(id)){
            citaRepository.deleteById(id);

            return "Cita cancelada";
        }else{

            return "No existe esta cita";
        }

    }

    @Override
    public String consultarDisponibilidad(String nombreDoctor){
        List<Cita> disponibilidad = citaRepository.findByNombreDoctor(nombreDoctor);
        if(disponibilidad!=null){
            String texto_dispo = "Horas ocupadas: ";
            for(Cita doctor : disponibilidad){
                texto_dispo += " " + doctor.getFechaHora().toString() + " ";
            }

            return texto_dispo;

        }else{

            return "Toda las horas disponibles";
        }
    }
}
