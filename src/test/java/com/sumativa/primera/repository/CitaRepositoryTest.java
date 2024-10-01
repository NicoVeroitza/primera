package com.sumativa.primera.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sumativa.primera.model.Cita;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CitaRepositoryTest {
    
    @Autowired
    private CitaRepository citaRepository;

    @Test
    public void guardarCitaTest(){
        Cita cita = new Cita();
        cita.setNombreDoctor("Pepito Diaz");

        Cita result = citaRepository.save(cita);

        assertNotNull(result.getId());
        assertEquals("Pepito Diaz", result.getNombreDoctor());
    }

    @Test
    public void busquedaFallidaTest(){
        Cita cita = new Cita();
        cita.setRutPaciente("11.111.111-1");

        citaRepository.save(cita);

        Cita result = citaRepository.findByRutPaciente("22.222.222-2");

        assertNull(result);


    }
}
