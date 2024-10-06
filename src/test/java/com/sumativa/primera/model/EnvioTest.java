package com.sumativa.primera.model;

import java.time.*;
import java.time.format.DateTimeFormatter; 
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class EnvioTest {

    @Test
    public void validacionFormatoFechaTest(){

        Envio envio = new Envio();
        
        assertDoesNotThrow(() ->  envio.setFechaHora(LocalDate.parse("2021-03-25")));

        /*
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse("2021-03-25", format));
        */


    }
    
}
