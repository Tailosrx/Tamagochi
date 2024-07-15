/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import info.Animal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author kevin
 */
public class EnciclopediaDialog extends JDialog{
   
     public EnciclopediaDialog(List<Animal> animales) {
        setTitle("Enciclopedia de Animales");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        mainPanel.setBackground(Color.BLACK);

        for (Animal animal : animales) {
            JPanel animalPanel = createAnimalPanel(animal);
            mainPanel.add(animalPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private JPanel createAnimalPanel(Animal animal) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        panel.setPreferredSize(new Dimension(350, 100));

        JLabel nameLabel = new JLabel(animal.getNombre());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Unispace", Font.BOLD, 16));

        JLabel moteLabel = new JLabel("Mote: " + animal.getMote());
        moteLabel.setForeground(Color.LIGHT_GRAY);
        moteLabel.setFont(new Font("Unispace", Font.ITALIC, 12));

        JLabel tipoLabel = new JLabel("Tipo: " + animal.getTipo());
        tipoLabel.setForeground(Color.WHITE);
        tipoLabel.setFont(new Font("Unispace", Font.PLAIN, 12));

        JLabel grupoLabel = new JLabel("Grupo: " + animal.getGrupo());
        grupoLabel.setForeground(Color.WHITE);
        grupoLabel.setFont(new Font("Unispace", Font.PLAIN, 12));

        JLabel saludLabel = new JLabel("Salud: " + animal.getSalud());
        saludLabel.setForeground(Color.WHITE);
        saludLabel.setFont(new Font("Unispace", Font.PLAIN, 12));

        panel.add(nameLabel);
        panel.add(moteLabel);
        panel.add(tipoLabel);
        panel.add(grupoLabel);
        panel.add(saludLabel);

        return panel;
    }
}
