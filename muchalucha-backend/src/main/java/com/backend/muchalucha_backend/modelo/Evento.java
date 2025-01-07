package com.backend.muchalucha_backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDate fecha;

    private String lugar;

    @Lob
    private String descripcion;

    private String imagen; // URL o ruta de la imagen

    // Relación ManyToMany con Luchador (opcional)
    @ManyToMany
    @JoinTable(
        name = "evento_luchador",
        joinColumns = @JoinColumn(name = "evento_id"),
        inverseJoinColumns = @JoinColumn(name = "luchador_id")
    )
    private Set<Luchador> luchadores;

    // Constructor vacío
    public Evento() {
    }

    // Constructor con parámetros (sin id)
    public Evento(String titulo, LocalDate fecha, String lugar, String descripcion, String imagen) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    // El método setId no se incluye ya que el ID es autogenerado

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(Set<Luchador> luchadores) {
        this.luchadores = luchadores;
    }
}