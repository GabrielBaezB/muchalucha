package com.backend.muchalucha_backend.repositorio;

import com.backend.muchalucha_backend.modelo.Luchador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuchadorRepositorio extends JpaRepository<Luchador, Long> {
    // Métodos personalizados si es necesario
}