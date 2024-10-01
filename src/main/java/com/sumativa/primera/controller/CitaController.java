package com.sumativa.primera.controller;

import com.sumativa.primera.model.Cita;
import com.sumativa.primera.service.CitaService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaController {
    

    private static final Logger log = LoggerFactory.getLogger(CitaController.class);

    @Autowired
    private CitaService citaService;

    @PostMapping
    public EntityModel<Cita> crearCita(@Validated @RequestBody Cita cita) {
        Cita citaCreada = citaService.crearCita(cita);
            return EntityModel.of(citaCreada, 
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(citaCreada.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllCitas()).withRel("all-citas"));
        
    }
    
    @DeleteMapping("/{id}")
    public String cancelarCita(@PathVariable Long id){
        return citaService.cancelarCita(id);
    }

    @GetMapping("/{doctor}")
    public String consultarDisponibilidad(@PathVariable String doctor){
        return citaService.consultarDisponibilidad(doctor);
    }

    @GetMapping("/id/{id}")
    public EntityModel<Cita> getCitaById(@PathVariable Long id){
        Optional<Cita> cita = citaService.getCitaById(id);

        if(cita.isPresent()){
            return EntityModel.of(cita.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllCitas()).withRel("all-citas"));
        } else {
            throw new CitaNotFoundException("Cita de ID: " + id + " no encontrada");
        }
    }

    @GetMapping
    public CollectionModel<EntityModel<Cita>> getAllCitas() {
        List<Cita> citas = citaService.getAllCitas();
        log.info("GET /citas");
        log.info("Retornando todos las citas");
        List<EntityModel<Cita>> citaResources = citas.stream()
            .map( cita -> EntityModel.of(cita,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(cita.getId())).withSelfRel()
            ))    
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllCitas());
        CollectionModel<EntityModel<Cita>> resources = CollectionModel.of(citaResources, linkTo.withRel("citas"));

        return resources;
    }
    

}
