/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import info.Animal;
import javax.swing.*;
import java.awt.*;

public class DetalleAnimalDialog extends JDialog {

    public DetalleAnimalDialog(Animal animal) {
        setTitle(animal.getMote() + " Details");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        
        JLabel nameLabel = new JLabel("Name: " + animal.getMote());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Poppins", Font.BOLD, 16));

        JLabel tipoLabel = new JLabel("Type: " + animal.getTipo());
        tipoLabel.setForeground(Color.WHITE);
        tipoLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        JLabel grupoLabel = new JLabel("Group: " + animal.getGrupo());
        grupoLabel.setForeground(Color.WHITE);
        grupoLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        JLabel saludLabel = new JLabel("Health: " + animal.getSalud());
        saludLabel.setForeground(Color.WHITE);
        saludLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        panel.add(nameLabel);
        panel.add(tipoLabel);
        panel.add(grupoLabel);
        panel.add(saludLabel);

        add(panel);
    }
}
