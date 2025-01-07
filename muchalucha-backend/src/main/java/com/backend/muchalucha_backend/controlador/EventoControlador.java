package com.backend.muchalucha_backend.controlador;

import com.backend.muchalucha_backend.modelo.Evento;
import com.backend.muchalucha_backend.repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoControlador {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @GetMapping
    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable Long id) {
        return eventoRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) {
        return eventoRepositorio.save(evento);
    }

    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable Long id, @RequestBody Evento detallesEvento) {
        return eventoRepositorio.findById(id).map(evento -> {
            evento.setTitulo(detallesEvento.getTitulo());
            evento.setFecha(detallesEvento.getFecha());
            evento.setLugar(detallesEvento.getLugar());
            evento.setDescripcion(detallesEvento.getDescripcion());
            evento.setImagen(detallesEvento.getImagen());
            evento.setLuchadores(detallesEvento.getLuchadores());
            return eventoRepositorio.save(evento);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoRepositorio.deleteById(id);
    }
}