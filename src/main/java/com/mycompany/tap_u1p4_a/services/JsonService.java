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
    
}
