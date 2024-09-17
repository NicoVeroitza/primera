package com.sumativa.primera.controller;

import com.sumativa.primera.dto.EnvioDTO;
import com.sumativa.primera.model.Envio;
import com.sumativa.primera.service.EnvioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/envios")
public class EnvioController {
    
    @Autowired
    private EnvioService envioService;

    @PostMapping
    public Envio crearEnvio(@RequestBody Envio envio) {
        return envioService.crearNuevoEnvio(envio);
    }
    
    @PutMapping
    public Envio actualizarEstado(@RequestBody EnvioDTO envioDTO) {
        return envioService.actualizarEstadoEnvio(envioDTO);
    }

    @GetMapping
    public String obtenerUbicacion(@RequestBody Long id) {
        return envioService.obtenerUbicacionActual(id);
    }
    
}
