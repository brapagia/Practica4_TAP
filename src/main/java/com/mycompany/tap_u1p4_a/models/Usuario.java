package com.mycompany.tap_u1p4_a.models;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author iscal
 */
public class Usuario implements Serializable {
    private String idUsuario;
    private String nombre;
    private String usuario;
    private String contrasenia;
    private String fotoPerfil;
    private boolean admin;
    private boolean activo = true;

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String contrasenia, String fotoPerfil, boolean admin) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.fotoPerfil = fotoPerfil;
        this.admin = admin;
        
        UUID obj = UUID.randomUUID();
        this.idUsuario = obj.toString();
    }

    public Usuario(String idUsuario, String nombre, String usuario, String contrasenia, String fotoPerfil, boolean admin) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.fotoPerfil = fotoPerfil;
        this.admin = admin;
    }    

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", fotoPerfil=" + fotoPerfil + ", admin=" + admin + ", activo=" + activo + '}';
    }
    
}
