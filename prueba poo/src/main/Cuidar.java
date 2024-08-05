/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import info.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Cuidar extends JDialog {
    private List<Animal> animales;
    private int playerLevel;
    private JList<String> animalList;

    public Cuidar(List<Animal> animales, int playerLevel) {
        this.animales = animales;
        this.playerLevel = playerLevel;

        setTitle("Cuidar Animales");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setModal(true);
        setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Animal animal : animales) {
            if (animal.getNivelDesbloqueo() <= playerLevel) {
                listModel.addElement(animal.getMote());
            } else {
                listModel.addElement("(Desbloqueado en nivel " + animal.getNivelDesbloqueo() + ")");
            }
        }
        
        animalList = new JList<>(listModel);
        animalList.setFont(new Font("Poppins", Font.PLAIN, 14));
        animalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        animalList.addListSelectionListener(e -> showAnimalDetails(animalList.getSelectedIndex()));
        JScrollPane listScrollPane = new JScrollPane(animalList);
        animalList.setBackground(Color.BLACK);
        animalList.setForeground(Color.WHITE);
        animalList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        animalList.addListSelectionListener(e -> showAnimalDetails(animalList.getSelectedIndex()));
        JScrollPane listScrollPane2 = new JScrollPane(animalList);

        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));

        JScrollPane detailScrollPane = new JScrollPane(detailPanel);
        detailScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        detailScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        detailScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(listScrollPane, BorderLayout.WEST);
        add(detailScrollPane, BorderLayout.CENTER);

        JButton feedButton = new JButton("Feed");
        feedButton.addActionListener(e -> feedAnimal(animalList.getSelectedIndex()));
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> playWithAnimal(animalList.getSelectedIndex()));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        add(animalList,BorderLayout.SOUTH);
        add(listScrollPane, BorderLayout.SOUTH);
        add(detailPanel, BorderLayout.SOUTH);
        add(detailScrollPane, BorderLayout.SOUTH);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });
    }

    private void showAnimalDetails(int index) {
        // Similar to your previous implementation for showing animal details
        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() > playerLevel) {
            return; // Skip locked animals
        }

        // Add logic to display animal details in the detailPanel
    }

    private void feedAnimal(int index) {
        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() <= playerLevel) {
            selectedAnimal.setSalud(selectedAnimal.getSalud() + 10); // Increase health by 10 as an example
            JOptionPane.showMessageDialog(this, selectedAnimal.getMote() + " has been fed!");
        }
    }

    private void playWithAnimal(int index) {
        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() <= playerLevel) {
            selectedAnimal.setSalud(selectedAnimal.getSalud() + 5); // Increase health by 5 as an example
            JOptionPane.showMessageDialog(this, "You played with " + selectedAnimal.getMote() + "!");
        }
    }
}
