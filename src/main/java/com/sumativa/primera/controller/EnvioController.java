package com.sumativa.primera.controller;

import com.sumativa.primera.dto.EnvioDTO;
import com.sumativa.primera.model.Envio;
import com.sumativa.primera.service.EnvioService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    
    private static final Logger log = LoggerFactory.getLogger(EnvioController.class);

    @Autowired
    private EnvioService envioService;

    @PostMapping
    public EntityModel<Envio> crearEnvio(@Validated @RequestBody Envio envio) {
        Envio envioCreado = envioService.crearNuevoEnvio(envio);
            return EntityModel.of(envioCreado, 
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(envioCreado.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-citas"));
    }
    
    @PutMapping
    public Envio actualizarEstado(@RequestBody EnvioDTO envioDTO) {
        return envioService.actualizarEstadoEnvio(envioDTO);
    }

    @GetMapping("/ubicacion/{id}")
    public String obtenerUbicacion(@PathVariable Long id) {
        return envioService.obtenerUbicacionActual(id);
    }
    
    @GetMapping("/id/{id}")
    public EntityModel<Envio> getEnvioById(@PathVariable Long id){
        Optional<Envio> envio = envioService.getEnvioById(id);

        if(envio.isPresent()){
            return EntityModel.of(envio.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
        } else {
            throw new EnvioNotFoundException("Envio de ID: " + id + " no encontrado");
        }
    }

    @GetMapping
    public CollectionModel<EntityModel<Envio>> getAllEnvios() {
        List<Envio> envios = envioService.getAllEnvios();
        log.info("GET /envios");
        log.info("Retornando todos los envios");
        List<EntityModel<Envio>> envioResources = envios.stream()
            .map( envio -> EntityModel.of(envio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(envio.getId())).withSelfRel()
            ))    
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios());
        CollectionModel<EntityModel<Envio>> resources = CollectionModel.of(envioResources, linkTo.withRel("envios"));

        return resources;
    }
}
