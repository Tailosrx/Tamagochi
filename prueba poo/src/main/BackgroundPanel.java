/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

     public BackgroundPanel() {
        try {
            URL url = getClass().getResource("/main/zoo.jpg"); // Ruta de la imagen
            if (url != null) {
                backgroundImage = ImageIO.read(url);
            }
            else{
                System.err.println("Ni idea donde esta la foto illo");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibujar la imagen de fondo
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            
            // Aplicar filtro grisáceo
            float alpha = 0.5f; // Nivel de opacidad (0.0f transparente a 1.0f opaco)
            g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, alpha));
            
            // Dibujar la imagen escalada para que se ajuste al tamaño del panel
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            
            g2d.dispose();
        }
    }
}
