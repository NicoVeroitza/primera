package com.sumativa.primera.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class EnvioDTOTest {
    
    @Test
    public void crearDTOTest(){
        String estado = "Estado a modificar";
        EnvioDTO dto = new EnvioDTO();
        dto.setEstado(estado);

        assertNotNull(dto);
        assertEquals(estado, dto.getEstado());
    }
}
