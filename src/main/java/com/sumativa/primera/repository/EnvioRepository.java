package com.sumativa.primera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumativa.primera.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long>{

    Envio findByRutCliente(String rut);
    Envio findFirstByRutCliente(String rut);
}