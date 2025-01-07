package com.backend.muchalucha_backend.repositorio;

import com.backend.muchalucha_backend.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {
    // Puedes agregar métodos personalizados si es necesario
}