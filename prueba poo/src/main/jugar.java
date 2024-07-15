/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;
import info.Animal;
import info.Vertebrado.*;
import info.Invertebrado.*;
import juego.Cuidar;

/**
 *
 * @author kjimenez.daw1r23
 */
public class jugar {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Cuidar c = new Cuidar();
        boolean cero = false;
        int index = -1;

        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(new Gato("Meu", "Gato", "Felinos", "vertebrado", 100));
        animales.add(new Gusano("Max", "Gusano", "Reptiles", "invertebrado", 100));
        animales.add(new Aguila("Articuno", "Aguila", "Aves", "vertebrado", 100));
        animales.add(new Tiburon("Laboon", "Tiburon", "Peces", "vertebrado", 100));
        animales.add(new Lagarto("Zeira", "Lagarto", "Reptiles", "vertebrado", 100));
        animales.add(new Koala("Benito", "Koala", "Mamiferos", "vertebrado", 100));
        animales.add(new Arana("Shallan", "Araña", "Aracnidos", "invertebrado", 100));
        animales.add(new Caracol("Turbo", "Caracol", "Moluscos", "invertebrado", 100));

        System.out.println("Bienvenida a tu zoo personal.");

        while (!cero) {
            Interfaz.menu_inicio();
            System.out.println("------------------------------");
            System.out.println("----------------------------");
            System.out.print("Opcion: ");

            int opcion = teclat.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleciona el animal que quieres ver: ");
                    System.out.println("------------------------------------");
                    for (int i = 0; i < animales.size(); i++) {
                        System.out.println((i + 1) + ". " + animales.get(i).getNombre());
                    }
                    
                    teclat.nextLine();
                    index = Integer.parseInt(teclat.nextLine()) - 1;

                    if (index >= 0 && index < animales.size()) {
                        Animal animalAlimentar = animales.get(index);
                        animales.get(index).mostrarInfo();
                    } else {
                        System.out.println("Animal inválido");
                    }

                    break;
                case 2:
                    System.out.println("Selecciona el animal a cuidar: ");

                    for (int i = 0; i < animales.size(); i++) {
                        System.out.println((i + 1) + ". " + animales.get(i).getNombre());
                    }
                    
                    
                    index = Integer.parseInt(teclat.nextLine()) - 1;
                    break;
                case 3:
                    cero = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    Interfaz.menu_inicio();
            }

        }
        teclat.close();
        System.out.println("¡Gracias por visitar el zoo!");
    }

}
