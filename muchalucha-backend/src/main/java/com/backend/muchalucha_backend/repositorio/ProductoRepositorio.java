package com.backend.muchalucha_backend.repositorio;

import com.backend.muchalucha_backend.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos personalizados si es necesario
}