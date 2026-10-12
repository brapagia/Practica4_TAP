package com.mycompany.tap_u1p4_a.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.tap_u1p4_a.models.Producto;
import com.mycompany.tap_u1p4_a.models.Usuario;
import com.mycompany.tap_u1p4_a.models.Venta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iscal
 */
public class JsonService {
    
    public static final String USERS_FILE = "usuarios.json";
    public static final String ITEMS_FILE = "productos.json";
    public static final String SALES_FILE = "ventas.json";
    
    public static boolean writeUsers(ArrayList<Usuario> users) {
        try {
            String json = new Gson().toJson(users);
            
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(USERS_FILE, false)
            );
            bw.write(json);
            bw.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Usuario> readUsers() {
        try {
            Path filePath = Path.of(USERS_FILE);
            String contenido = Files.readString(filePath);
            
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            return new Gson().fromJson(contenido, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Usuario>();
        }
    }
    
    public static boolean writeItems(ArrayList<Producto> items) {
        try {
            String json = new Gson().toJson(items);
            
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(ITEMS_FILE, false)
            );
            bw.write(json);
            bw.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Producto> readItems() {
        try {
            Path filePath = Path.of(ITEMS_FILE);
            String contenido = Files.readString(filePath);
            
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Producto>>(){}.getType();
            return new Gson().fromJson(contenido, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Producto>();
        }
    }
    
    public static boolean writeSales(ArrayList<Venta> sales) {
        try {
            String json = new Gson().toJson(sales);
            
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(SALES_FILE, false)
            );
            bw.write(json);
            bw.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Venta> readSales() {
        try {
            Path filePath = Path.of(SALES_FILE);
            String contenido = Files.readString(filePath);
            
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Venta>>(){}.getType();
            return new Gson().fromJson(contenido, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Venta>();
        }
    }
    
            // --- CRUD DE PRODUCTOS ---

            // READ: Obtener solo los productos que NO están eliminados (Soft Delete)
    public static List<Producto> getProductosActivos() {
        ArrayList<Producto> todos = readItems(); // Corregido
        List<Producto> activos = new ArrayList<>();
        for (Producto p : todos) {
            if (p.isActivo()) {
                activos.add(p);
            }
        }
        return activos;
    }

    // UPDATE & CREATE: Guardar o actualizar un producto
    public static void upsertProducto(Producto nuevoProducto) {
        ArrayList<Producto> productos = readItems();
        boolean existe = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto().equals(nuevoProducto.getIdProducto())) {
                productos.set(i, nuevoProducto); // Actualiza si existe
                existe = true;
                break;
            }
        }
        if (!existe) {
            productos.add(nuevoProducto); // Crea si no existe
        }
        writeItems(productos); // Corregido: Usa tu método real
    }

    // DELETE: Soft Delete (solo cambia el estado, no lo borra del archivo)
    public static void softDeleteProducto(String idProducto) {
        ArrayList<Producto> productos = readItems();
        for (Producto p : productos) {
            if (p.getIdProducto().equals(idProducto)) {
                p.setActivo(false); // Se marca como eliminado
                break;
            }
        }
        writeItems(productos); // Corregido: Usa tu método real
    }

    // --- FILTRO DE VENTAS ---
    // Buscar ventas por múltiples filtros (si un filtro es null o vacío, se ignora)
    public static List<Venta> filtrarVentas(String idProducto, String idUsuario, String fecha) {
        ArrayList<Venta> todas = readSales(); // Corregido: Lee de ventas, no de productos
        List<Venta> filtradas = new ArrayList<>();

        for (Venta v : todas) {
            boolean coincideProducto = (idProducto == null || idProducto.isEmpty()) || v.getUsuario().equals(idProducto);
            boolean coincideUsuario = (idUsuario == null || idUsuario.isEmpty()) || v.getUsuario().equals(idUsuario);
            boolean coincideFecha = (fecha == null || fecha.isEmpty()) || v.getFecha().equals(fecha);

            if (coincideProducto && coincideUsuario && coincideFecha) {
                filtradas.add(v);
            }
        }
        return filtradas;
    }    
}
