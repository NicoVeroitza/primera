package com.sumativa.primera;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EnvioController {

    // Lista que almacena los objetos usados en el controlador
    private List<Envio> envios =  new ArrayList<>();
 
    public EnvioController(){
        /*  Creación de objetos de clase Envio con distintos parámetros (y uno vacío)
            La ubicación la denominé como estado del envío para simplificar */
        Envio envioUno = new Envio(1, LocalDateTime.parse("11-11-2011 23:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "Guillermo", "Fuentes", "Sucursal");
        Envio envioDos = new Envio(2, LocalDateTime.parse("12-12-2012 14:30", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "Andrés", "Palma", "Sucursal");
        Envio envioTres = new Envio(3, LocalDateTime.parse("06-06-2006 09:20", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), "Nicolás", "Veroitza", "En camino");
        Envio envioCuatro = new Envio(4, LocalDateTime.parse("12/01/2000 05:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "Mauricio", "Morales", "En almacén");
        Envio envioCinco = new Envio(5, LocalDateTime.parse("01/05/2020 23:45", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "Luis", "Larrondo", "En camnino");
        Envio envioSeis = new Envio();

        envios.add(envioUno);
        envios.add(envioDos);
        envios.add(envioTres);
        envios.add(envioCuatro);
        envios.add(envioCinco);
        envios.add(envioSeis);

    }

    // Función que devuelve todas los envios (el formato de salida es un JSON)
    @GetMapping("/envios/listar")
    public List<Envio> listarEnvios(){
        return envios;
    }

    //End-point que devuelve una envio según su ID
    @GetMapping("/envios/{id}")
    public String buscarEnvio(@PathVariable("id") int id) {
        try {
            for(Envio envio : envios){
            
                if(envio.getId() == id){
                    // Use un salto de línea de HTML para que se vea mejor
                    return "Fecha y hora de envio: " + envio.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")).toString() + 
                    "</br>" +  "Nombre de cliente: " + envio.getNombreApellido() + 
                    "</br>" + "Estado/ubicación del envío: " + envio.getUbicacion();
                }  
            }  
            return "No existe este envío.";
            
        } catch (Exception e) {
            return "Ingrese un ID numérico";
        }
     
    }
    
}
