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
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes_contacto")
public class MensajeContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Lob
    private String mensaje;

    private LocalDateTime fechaEnvio;

    // Constructor vacío
    public MensajeContacto() {
    }

    // Constructor con parámetros
    public MensajeContacto(String nombre, String email, String mensaje, LocalDateTime fechaEnvio) {
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
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

    public String getEmail() {
        return email;
    }
    
    /* Si deseas validar el formato del email, puedes agregar una anotación:
    @Email
    private String email;
    y agregar las validaciones correspondientes.
    */

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}