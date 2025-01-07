package com.backend.muchalucha_backend.controlador;

import com.backend.muchalucha_backend.modelo.Producto;
import com.backend.muchalucha_backend.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepositorio.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        return productoRepositorio.findById(id).map(producto -> {
            producto.setNombre(detallesProducto.getNombre());
            producto.setDescripcion(detallesProducto.getDescripcion());
            producto.setPrecio(detallesProducto.getPrecio());
            producto.setImagen(detallesProducto.getImagen());
            return productoRepositorio.save(producto);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepositorio.deleteById(id);
    }
}