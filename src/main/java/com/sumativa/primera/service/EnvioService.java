package com.sumativa.primera.service;

import com.sumativa.primera.DTO.*;
import com.sumativa.primera.model.Envio;
import java.util.List;
import java.util.Optional;

public interface EnvioService {
    Envio crearNuevoEnvio(Envio envio);
    Envio actualizarEstadoEnvio(EnvioDTO envioDTO);
    String obtenerUbicacionActual(Long id);
}
