package com.sumativa.primera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa.primera.dto.EnvioDTO;
import com.sumativa.primera.model.Envio;
import com.sumativa.primera.repository.EnvioRepository;


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
            return envio.getUbicacionActual();
        }
        else{
            return null;
        }

    }
}



