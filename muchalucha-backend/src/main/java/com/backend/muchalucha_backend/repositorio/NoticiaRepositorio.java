package com.backend.muchalucha_backend.repositorio;

import com.backend.muchalucha_backend.modelo.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {
    // Métodos personalizados si es necesario
}