package com.backend.muchalucha_backend.controlador;

import com.backend.muchalucha_backend.modelo.Luchador;
import com.backend.muchalucha_backend.repositorio.LuchadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/luchadores")
@CrossOrigin(origins = "http://localhost:4200")
public class LuchadorControlador {

    @Autowired
    private LuchadorRepositorio luchadorRepositorio;

    @GetMapping
    public List<Luchador> obtenerTodosLosLuchadores() {
        return luchadorRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Luchador obtenerLuchadorPorId(@PathVariable Long id) {
        return luchadorRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public Luchador crearLuchador(@RequestBody Luchador luchador) {
        return luchadorRepositorio.save(luchador);
    }

    @PutMapping("/{id}")
    public Luchador actualizarLuchador(@PathVariable Long id, @RequestBody Luchador detallesLuchador) {
        return luchadorRepositorio.findById(id).map(luchador -> {
            luchador.setNombre(detallesLuchador.getNombre());
            luchador.setEdad(detallesLuchador.getEdad());
            luchador.setPeso(detallesLuchador.getPeso());
            luchador.setAltura(detallesLuchador.getAltura());
            luchador.setNacionalidad(detallesLuchador.getNacionalidad());
            luchador.setBiografia(detallesLuchador.getBiografia());
            luchador.setImagen(detallesLuchador.getImagen());
            return luchadorRepositorio.save(luchador);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarLuchador(@PathVariable Long id) {
        luchadorRepositorio.deleteById(id);
    }
}