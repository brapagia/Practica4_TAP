package com.mycompany.tap_u1p4_a.services;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.edisoncor.gui.panel.PanelImage;

/**
 *
 * @author iscal
 */
public class ImageService {
    
    public static String setPanelImage(JFileChooser selector, PanelImage panel) {
        if(selector.showOpenDialog(null) ==
            JFileChooser.APPROVE_OPTION) {
            // Si eligio un archivo
            File file = selector.getSelectedFile();
            // Se comprueba que sea una imagen
            if(file.getName().endsWith(".jpg") ||
            file.getName().endsWith(".png") ||
            file.getName().endsWith(".jpeg")) {
                // Se guarda la imagen en variable
                String imagePath = file.getAbsolutePath();
                // Se coloca la imagen en el PanelImage
                panel.setIcon(
                    new javax.swing.ImageIcon(
                        imagePath
                    )
                );
                panel.updateUI();
                
                return imagePath;
            } else {
                JOptionPane.showMessageDialog(null,"No es una imagen");
                return null;
            }
        }
        return null;
    }
    
}
