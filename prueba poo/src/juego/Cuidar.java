/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import info.Animal;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Cuidar {

    

    public void comer(Animal a, Scanner teclat) {
        System.out.println("Escribe lo que el/la " + a.getNombre() + " debe comer: ");
        String alimento = teclat.nextLine();
        System.out.println("");

        Random r = new Random();
        int num = r.nextInt(101);

        if (num < 50) {
            System.out.println("Vaya... la comida está caducada.");
            a.setSalud(a.getSalud() - 10);
            if (num == 0) {
                System.out.println("El animal ha enfermado y ha acabado falleciendo.");
                a.setSalud(a.getSalud() - 100);
            }
        } else if (num >= 50) {
            System.out.println("La comida esta en buen estado.");
            a.setSalud(a.getSalud() + 10);
            
            if (num == 100) {
                System.out.println("A " + a.getNombre() + "le ha encantado la comida");
            }
        }
        System.out.println("");
        if (a.getSalud() < 0) {
            a.setSalud(0);
        } else if (a.getSalud() > 100) {
            a.setSalud(100);

        }
    }

}
