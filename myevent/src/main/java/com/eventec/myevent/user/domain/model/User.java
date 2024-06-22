package com.eventec.myevent.user.domain.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private String contrasena;
    private Date fechaCreacion;
    private Date fechaSuspension;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartera_id", referencedColumnName = "id")
    private Cartera cartera;

     */

    // Constructor vacío para JPA
    protected User() {}

    // Constructor completo
    public User(String nombre, String apellido, String direccion, String correoElectronico, String telefono, String contrasena, Date fechaCreacion, Date fechaSuspension) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion;
        this.fechaSuspension = fechaSuspension;
        //this.cartera = cartera;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSuspension() {
        return fechaSuspension;
    }

    public void setFechaSuspension(Date fechaSuspension) {
        this.fechaSuspension = fechaSuspension;
    }
/*
    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

 */
}
