package com.sumativa.primera.service;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa.primera.model.Cita;
import com.sumativa.primera.repository.CitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> getAllCitas(){
        return citaRepository.findAll();
    }

    public Optional<Cita> getCitaById(Long id){
        return citaRepository.findById(id);
    }
}
