package com.backend.muchalucha_backend.controlador;

import com.backend.muchalucha_backend.modelo.MensajeContacto;
import com.backend.muchalucha_backend.repositorio.MensajeContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class MensajeContactoControlador {

    @Autowired
    private MensajeContactoRepositorio mensajeContactoRepositorio;

    @GetMapping
    public List<MensajeContacto> obtenerTodosLosMensajes() {
        return mensajeContactoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public MensajeContacto obtenerMensajePorId(@PathVariable Long id) {
        return mensajeContactoRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public MensajeContacto crearMensaje(@RequestBody MensajeContacto mensajeContacto) {
        mensajeContacto.setFechaEnvio(java.time.LocalDateTime.now());
        return mensajeContactoRepositorio.save(mensajeContacto);
    }

    @DeleteMapping("/{id}")
    public void eliminarMensaje(@PathVariable Long id) {
        mensajeContactoRepositorio.deleteById(id);
    }
}