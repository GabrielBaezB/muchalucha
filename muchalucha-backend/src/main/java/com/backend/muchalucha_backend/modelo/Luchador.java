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

import java.util.Set;

@Entity
@Table(name = "luchadores")
public class Luchador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    private String nacionalidad;

    @Lob
    private String biografia;

    private String imagen; // URL o ruta de la imagen

    // Relación ManyToMany con Evento
    @ManyToMany(mappedBy = "luchadores")
    private Set<Evento> eventos;

    // Constructor
    public Luchador() {
    }

    // Constructor con parámetros
    public Luchador(String nombre, int edad, double peso, double altura, String nacionalidad, String biografia, String imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
        this.imagen = imagen;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    // No se incluye setId ya que el ID es autogenerado

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }
    
    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}