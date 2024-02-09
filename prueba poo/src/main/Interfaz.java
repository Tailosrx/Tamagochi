/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import juego.Cuidar;
import info.Animal;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Interfaz {

   

    public static void menu_inicio() {
        System.out.println("\nQue deseas hacer?");
        System.out.println("1. Ver estado de los animales");
        System.out.println("2. Cuidar a los animales");
        System.out.println("3. Salir");
    }

    public static void menu_cuidar(ArrayList<Animal> animales, Scanner teclat) {
        Cuidar cuidador = new Cuidar();
        boolean volver = false;
        
        while (!volver) {
            System.out.println("Elige una acción:");
            System.out.println("1. Alimentar");
            System.out.println("2. Limpiar");
            System.out.println("3. Jugar");
            System.out.println("4. Volver");

            int opcionCuidar = Integer.parseInt(teclat.nextLine());

            switch (opcionCuidar) {
                case 1:
                    // Alimentar
                    System.out.println("Selecciona el animal a alimentar:");
                    // Mostrar lista de animales
                    int indexAlimentar = Integer.parseInt(teclat.nextLine()) - 1;
                    Animal animalAlimentar = animales.get(indexAlimentar);
                    cuidador.comer(animalAlimentar, teclat);
                    break;
                case 2:
                    // Limpiar
                    // Lógica para limpiar al animal
                    break;
                case 3:
                    // Jugar
                    // Lógica para jugar con el animal
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }
}
