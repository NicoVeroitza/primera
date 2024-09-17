package com.sumativa.primera.service;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa.primera.DTO.EnvioDTO;
import com.sumativa.primera.model.Envio;
import com.sumativa.primera.repository.EnvioRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService{

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public Envio crearNuevoEnvio(Envio envio){
        return envioRepository.save(envio);
    }

    @Override
    public Envio actualizarEstadoEnvio(EnvioDTO envioDTO){

        if(envioRepository.existsById(envioDTO.id)){

            Envio envio = new Envio();
            envio.setId(envioDTO.id);
            envio.setEstadoEnvio(envioDTO.estado);

            return envioRepository.save(envio);

        }else{
            return null;
        }
    }

    @Override
    public String obtenerUbicacionActual(Long id){
        Optional<Envio> queryEnvio = envioRepository.findById(id);
        if(queryEnvio.isPresent()){
            Envio envio = queryEnvio.get();
            return envio.getEstadoEnvio();
        }
        else{
            return null;
        }

    }
}



