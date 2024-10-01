package com.sumativa.primera.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sumativa.primera.model.Envio;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnvioRepositoryTest {
    
    @Autowired
    private EnvioRepository envioRepository;

    // Hay unas cuantas redundancias, pero quise probar simplemente.
    @Test
    public void actualizarDataEnvioTest(){
        Envio envio = new Envio();

        envio.setRutCliente("11.111.111-1");
        envio.setNombreCliente("Nicolas");
        envio.setFechaHora(new Date());

        envioRepository.save(envio);

        Envio modificacion = envioRepository.findByRutCliente("11.111.111-1");

        assertNotNull(modificacion);


        if(modificacion!=null){
            modificacion.setRutCliente("22.222.222-2");
            modificacion.setNombreCliente("Andrés");

            envioRepository.save(modificacion);

            Envio envioModificado = envioRepository.findByRutCliente("22.222.222-2");
            assertNotNull(envioModificado);
            assertEquals(modificacion.getRutCliente(), envioModificado.getRutCliente());
            
        }

        
    }
}
