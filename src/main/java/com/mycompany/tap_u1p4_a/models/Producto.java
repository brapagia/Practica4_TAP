package com.mycompany.tap_u1p4_a.models;

import java.io.Serializable;

/**
 *
 * @author iscal
 */
public class Producto implements Serializable {
    private String idProducto;
    private String nombre;
    private Double precio;
    private String imagen;
    private boolean activo;

    public Producto() {
    }

    public Producto(String idProducto, String nombre, Double precio, String imagen, boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + ", activo=" + activo + '}';
    }
    
}
