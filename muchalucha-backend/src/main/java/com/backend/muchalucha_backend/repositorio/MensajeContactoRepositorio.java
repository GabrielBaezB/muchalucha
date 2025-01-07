package com.backend.muchalucha_backend.repositorio;

import com.backend.muchalucha_backend.modelo.MensajeContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeContactoRepositorio extends JpaRepository<MensajeContacto, Long> {
    // Métodos personalizados si es necesario
}