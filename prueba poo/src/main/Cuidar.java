package main;

import info.Animal;
import juego.Comer;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Cuidar extends JFrame {
    private List<Animal> animales;
    private int playerLevel;
    private JLabel hambreLabel;
    private JLabel aburrimientoLabel;
    private JProgressBar healthBar;
    private JPanel detailPanel;
    private JList<String> animalList;

    public Cuidar(List<Animal> animales, int playerLevel) {
        this.animales = animales;
        this.playerLevel = playerLevel;
        this.detailPanel = new JPanel();
        this.detailPanel.setLayout(new BorderLayout());

        // Inicialización del modelo de la lista
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
        animalList.setBackground(Color.BLACK);
        animalList.setForeground(Color.WHITE);
        animalList.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        JScrollPane listScrollPane = new JScrollPane(animalList);

        hambreLabel = new JLabel();
        hambreLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        hambreLabel.setForeground(Color.BLACK);
        hambreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        aburrimientoLabel = new JLabel();
        aburrimientoLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        aburrimientoLabel.setForeground(Color.BLACK);
        aburrimientoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        healthBar = new JProgressBar(0, 100);
        healthBar.setForeground(Color.GREEN);
        healthBar.setBackground(Color.RED);
        healthBar.setPreferredSize(new Dimension(200, 20));
        healthBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        

        JButton feedButton = new JButton("Alimentar");
        estilo(feedButton);
        feedButton.addActionListener(e -> feedSelectedAnimal());
        feedButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton playButton = new JButton("Jugar");
        estilo(playButton);
        playButton.addActionListener(e -> playWithAnimal(animalList.getSelectedIndex()));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addHoverEffect(feedButton);
        addHoverEffect(playButton);

        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.add(hambreLabel);
        detailPanel.add(aburrimientoLabel);
        detailPanel.add(healthBar);
        detailPanel.add(feedButton);
        detailPanel.add(Box.createRigidArea(new Dimension(0, 20)));  
        detailPanel.add(playButton);

        add(listScrollPane, BorderLayout.WEST);
        add(detailPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);  // Aquí se muestra la ventana
    }

    private void estilo(JButton button) {
        button.setFont(new Font("Poppins", Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.CYAN);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setPreferredSize(new Dimension(200, 60));
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.CYAN);
            }
        });
    }

    private void showAnimalDetails(int index) {
        if (index == -1) {
            hambreLabel.setText("Hambruna: ");
            aburrimientoLabel.setText("Aburrimiento: ");
            healthBar.setValue(0);
            return;
        }

        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() > playerLevel) {
            return;
        }

        hambreLabel.setText("Hambruna: " + selectedAnimal.getHambre());
        aburrimientoLabel.setText("Aburrimiento: " + selectedAnimal.getAburrimiento());
        healthBar.setValue(selectedAnimal.getSalud());
    }

    private void feedSelectedAnimal() {
        int index = animalList.getSelectedIndex();
        if (index != -1 && animales.get(index).getNivelDesbloqueo() <= playerLevel) {
            Comer c = new Comer(animales.get(index), resultado -> {
                handleFeedingResult(index, resultado);
            });
            c.start();
        } else if (index == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un animal antes de alimentarlo.");
        } else {
            JOptionPane.showMessageDialog(null, "Este animal no está desbloqueado todavía.");
        }
    }

    private void handleFeedingResult(int index, int resultado) {
        Animal selectedAnimal = animales.get(index);
        if (resultado == Comer.EXITO) {
            selectedAnimal.setSalud(selectedAnimal.getSalud() + 10);
            selectedAnimal.setHambre(selectedAnimal.getHambre() - 30);
            if (selectedAnimal.getHambre() < 0) {
                selectedAnimal.setHambre(0);
            } else if (selectedAnimal.getSalud() > 100) {
                selectedAnimal.setSalud(100);
            }
            JOptionPane.showMessageDialog(null, selectedAnimal.getMote() + " ha disfrutado la comida!");
        } else {
            selectedAnimal.setSalud(selectedAnimal.getSalud() - 20);
            selectedAnimal.setHambre(selectedAnimal.getHambre() + 20);
            if (selectedAnimal.getSalud() < 0) {
                selectedAnimal.setSalud(0);
            }
            JOptionPane.showMessageDialog(null, selectedAnimal.getMote() + " no parece satisfecho.");
        }
        showAnimalDetails(index);
    }

    private void playWithAnimal(int index) {
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un animal antes de jugar con él.");
            return;
        }

        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() <= playerLevel) {
            selectedAnimal.setSalud(selectedAnimal.getSalud() + 5);
            selectedAnimal.setAburrimiento(selectedAnimal.getAburrimiento() - 20);
            if (selectedAnimal.getAburrimiento() < 0) {
                selectedAnimal.setAburrimiento(0);
            }
            JOptionPane.showMessageDialog(null, "¡Jugaste con " + selectedAnimal.getMote() + "!");
            showAnimalDetails(index);
        }
    }
}
