package com.sumativa.primera.controller;

import com.sumativa.primera.model.Cita;
import com.sumativa.primera.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {
    
    @Autowired
    private CitaService citaService;

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaService.crearCita(cita);
        
    }
    
    @DeleteMapping("/{id}")
    public String cancelarCita(@PathVariable Long id){
        return citaService.cancelarCita(id);
    }

    @GetMapping("/{doctor}")
    public String consultarDisponibilidad(@PathVariable String doctor){
        return citaService.consultarDisponibilidad(doctor);
    }
    

}
