package main;

import info.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EnciclopediaDialog extends JDialog {

    private JList<String> animalList;
    private JPanel detailPanel;
    private List<Animal> animales;
    private int playerLevel;

    public EnciclopediaDialog(List<Animal> animales, int playerLevel) {
        this.playerLevel = playerLevel;
        this.animales = animales;

        setTitle("Enciclopedia de Animales");
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

        listScrollPane.setPreferredSize(new Dimension(200, 600));

        detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setBackground(Color.DARK_GRAY);
        detailPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        JScrollPane detailScrollPane = new JScrollPane(detailPanel);
        detailScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        detailScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        detailScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(listScrollPane, BorderLayout.WEST);
        add(detailScrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void showAnimalDetails(int index) {
        Animal selectedAnimal = animales.get(index);
        if (selectedAnimal.getNivelDesbloqueo() > playerLevel) {
            return; // Skip locked animals
        }

        detailPanel.removeAll();

        JLabel nameLabel = new JLabel(selectedAnimal.getMote());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel tipoLabel = new JLabel(selectedAnimal.getTipo());
        tipoLabel.setForeground(Color.WHITE);
        tipoLabel.setFont(new Font("Poppins", Font.BOLD, 13));
        tipoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel grupoLabel = new JLabel(selectedAnimal.getGrupo());
        grupoLabel.setForeground(Color.WHITE);
        grupoLabel.setFont(new Font("Poppins", Font.BOLD, 13));
        grupoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JLabel hambreLabel = new JLabel("Hambre: " + selectedAnimal.getHambre());
        hambreLabel.setForeground(Color.WHITE);
        hambreLabel.setFont(new Font("Poppins", Font.BOLD, 13));
        hambreLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        JLabel aburrimientoLabel = new JLabel("Aburrimiento: " + selectedAnimal.getAburrimiento());
        aburrimientoLabel.setForeground(Color.WHITE);
        aburrimientoLabel.setFont(new Font("Poppins", Font.BOLD, 13));
        aburrimientoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Creating a health bar
        JProgressBar healthBar = new JProgressBar(0, 100);
        healthBar.setValue(selectedAnimal.getSalud());
        healthBar.setStringPainted(true);
        healthBar.setForeground(Color.GREEN);
        healthBar.setBackground(Color.RED);
        healthBar.setPreferredSize(new Dimension(200, 20));
        healthBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedAnimal.getImagePath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(imageIcon);
        
        JTextArea info = new JTextArea(selectedAnimal.getInfo());
        info.setWrapStyleWord(true);
        info.setLineWrap(true);
        info.setEditable(false);
        info.setForeground(Color.WHITE);
        info.setBackground(Color.DARK_GRAY);
        info.setFont(new Font("Poppins", Font.BOLD, 13));

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tipoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hambreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        aburrimientoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        detailPanel.add(Box.createVerticalStrut(10)); // Add space at the top
        detailPanel.add(imageLabel);
        detailPanel.add(Box.createVerticalStrut(10)); // Add space between elements
        detailPanel.add(nameLabel);
        detailPanel.add(tipoLabel);
        detailPanel.add(grupoLabel);
        detailPanel.add(hambreLabel);
        detailPanel.add(aburrimientoLabel);
        detailPanel.add(healthBar);
        detailPanel.add(info);
        detailPanel.add(Box.createVerticalGlue()); // Add space at the bottom

        detailPanel.revalidate();
        detailPanel.repaint();
    }
}
