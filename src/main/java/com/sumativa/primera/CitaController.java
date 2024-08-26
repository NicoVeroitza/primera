package com.sumativa.primera;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CitaController {
    // Lista que almacena los objetos usados en el controlador
    private List<Cita> citas = new ArrayList<>();
    
    public CitaController(){
        // Creación de objetos de clase Cita con distintos parámetros
        Cita citaUno = new Cita(1, LocalDateTime.parse("16-06-2060 15:45", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "14444888-5", "Orlando", "Toro");
        Cita citaDos = new Cita(2, LocalDateTime.parse("25-07-2010 12:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "12574888-3", "Gabriel", "Piñera");
        Cita citaTres = new Cita(3, LocalDateTime.parse("01-08-2014 09:10", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "19765398-K", "Angela", "Ziegler");
        Cita citaCuatro = new Cita(4, LocalDateTime.parse("12-10-2034 17:30", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "18956239-6", "Elizabeth", "Caledonia");
        Cita citaCinco = new Cita(5, LocalDateTime.parse("30-11-2024 15:45", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "11456298-5", "Violeta", "Mendoza");

        citas.add(citaUno);
        citas.add(citaDos);
        citas.add(citaTres);
        citas.add(citaCuatro);
        citas.add(citaCinco);

    }


    // Función que devuelve todas las citas agendadas (el formato de salida es un JSON)
    @GetMapping("/citas/listar")
    public List<Cita> listarCitas() {
        return citas;
    }

    /* Función que permite consultar la existencia o no de una hora médica según su fecha y hora (para comprobar disponibilidad)
       Ingresar fecha y hora en formato definido en el Parse dentro de la función */
    @GetMapping("/citas/{fecha}/{hora}")
    public String checkearDisponibilidad(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
        String fechaIngresada = fecha + " " + hora;
        LocalDateTime fechaQuery = LocalDateTime.parse(fechaIngresada, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        /* Comprueba si la fecha ingresada es igual a alguna fecha de alguna cita ya ingresada 
           La comparación es simple debido a la naturaleza de la evaluación, obviamente habría que crear un rango de tiempo para comparar en vez de simplemente una hora puntual*/ 
        for (Cita cita : citas){
            if(fechaQuery.isEqual(cita.getFechaHora())){
                return "No está disponible esta hora.";
            }
        }

        return "Hora disponible para cita médica";
    }
    
    
}
