package com.backend.muchalucha_backend.controlador;

import com.backend.muchalucha_backend.modelo.Noticia;
import com.backend.muchalucha_backend.repositorio.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
@CrossOrigin(origins = "http://localhost:4200")
public class NoticiaControlador {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @GetMapping
    public List<Noticia> obtenerTodasLasNoticias() {
        return noticiaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Noticia obtenerNoticiaPorId(@PathVariable Long id) {
        return noticiaRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public Noticia crearNoticia(@RequestBody Noticia noticia) {
        noticia.setFechaPublicacion(java.time.LocalDateTime.now());
        return noticiaRepositorio.save(noticia);
    }

    @PutMapping("/{id}")
    public Noticia actualizarNoticia(@PathVariable Long id, @RequestBody Noticia detallesNoticia) {
        return noticiaRepositorio.findById(id).map(noticia -> {
            noticia.setTitulo(detallesNoticia.getTitulo());
            noticia.setContenido(detallesNoticia.getContenido());
            noticia.setAutor(detallesNoticia.getAutor());
            // Mantener o actualizar la fecha de publicación según se requiera
            return noticiaRepositorio.save(noticia);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarNoticia(@PathVariable Long id) {
        noticiaRepositorio.deleteById(id);
    }
}