package com.mycompany.tap_u1p4_a.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 *
 * @author iscal
 */
public class Venta implements Serializable {
    private String idVenta;
    private String fecha;
    private Double total;
    private Integer cantidad;
    private Producto producto;
    private Usuario usuario;

    public Venta() {
        this.idVenta = UUID.randomUUID().toString();
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        this.fecha = format.format(new Date());
    }

    public Venta(String fecha, Double total, Integer cantidad, Producto producto, Usuario usuario) {
        this.idVenta = UUID.randomUUID().toString();
        this.fecha = fecha;
        this.total = total;
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", total=" + total + ", cantidad=" + cantidad + ", producto=" + producto + ", usuario=" + usuario + '}';
    }
    
}
